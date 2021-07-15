package com.hlzt.framework.web.service;

import cn.hutool.core.util.CreditCodeUtil;
import com.hlzt.common.constant.Constants;
import com.hlzt.common.constant.UserConstants;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.core.domain.entity.SysUser;
import com.hlzt.common.core.domain.model.LoginUser;
import com.hlzt.common.core.domain.model.RegisterBody;
import com.hlzt.common.core.redis.RedisCache;
import com.hlzt.common.enums.DeptType;
import com.hlzt.common.enums.RoleType;
import com.hlzt.common.exception.CustomException;
import com.hlzt.common.exception.user.CaptchaException;
import com.hlzt.common.exception.user.CaptchaExpireException;
import com.hlzt.common.exception.user.UserPasswordNotMatchException;
import com.hlzt.common.utils.*;
import com.hlzt.common.utils.bean.BeanUtils;
import com.hlzt.common.utils.ip.IpUtils;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.framework.manager.AsyncManager;
import com.hlzt.framework.manager.factory.AsyncFactory;
import com.hlzt.system.service.ISysDeptService;
import com.hlzt.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author ruo-yi
 */
@Component
public class SysLoginService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService userService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * 登录验证
     *
     * @param username 用户名/电话
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, RsaUtils.decryptByPrivateKey(password)));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUser());
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user)
    {
        user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(user);
    }

    @Transactional
    public AjaxResult register(RegisterBody registerBody) {
        SysDept sysDept = new SysDept();
        BeanUtils.copyBeanProp(sysDept, registerBody);
        sysDept.setStatus(UserConstants.DEPT_DISABLE);
        sysDept.setLeader(registerBody.getLeader());
        sysDept.setPhone(registerBody.getPhone());
        sysDept.setDeptType(UserConstants.COMPANY);

        String username = registerBody.getPhonenumber();
        String uuid = registerBody.getUuid();
        String code = registerBody.getCode();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        if (code.equalsIgnoreCase(captcha)) {

            if (!CreditCodeUtil.isCreditCode(sysDept.getCreditCode())) {
                throw new RuntimeException("统一社会信用代码格式不正确！");
            }

            int count = sysDeptService.checkCreditUnique(sysDept.getCreditCode());
            if (count > 0) {
                throw new RuntimeException("您申请的单位已经注册，请联系单位业务管理人!");
            }

            SysUser user = new SysUser();
            user.setPhonenumber(registerBody.getPhonenumber());
            if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
                throw new RuntimeException("用户电话已经注册");
            }

            if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(username))) {
                throw new RuntimeException("用户名已经注册");
            }

            sysDeptService.insertDept(sysDept);

            SysUser sysUser = new SysUser();

            sysUser.setDeptId(sysDept.getDeptId())
                    .setPassword(SecurityUtils.encryptPassword(registerBody.getPassword()))
                    .setUserName(IdUtils.getNextId().toString())
                    .setNickName(registerBody.getNickName())
                    .setPhonenumber(registerBody.getPhonenumber())
                    .setStatus(UserConstants.USER_DISABLE);
            //建筑方 ID 100L  服务方ID 300L
            if (registerBody.getParentId().equals(DeptType.CONSTRUCTION.getDeptId())) {
                sysUser.setRoleIds(new Long[]{RoleType.CONSTRUCTION.getRoleId(),RoleType.CONSTRUCTION_ADMIN.getRoleId()});
            } else if (registerBody.getParentId().equals(DeptType.SERVICE.getDeptId())) {
                sysUser.setRoleIds(new Long[]{RoleType.SERVICE.getRoleId(),RoleType.SERVICE_ADMIN.getRoleId()});
            }
            userService.insertUser(sysUser);
        }
        return AjaxResult.success();
    }
}
