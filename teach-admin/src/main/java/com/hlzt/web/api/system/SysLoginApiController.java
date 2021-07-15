package com.hlzt.web.api.system;

import com.hlzt.common.constant.Constants;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.entity.SysUser;
import com.hlzt.common.core.domain.model.LoginBody;
import com.hlzt.common.core.domain.model.LoginUser;
import com.hlzt.common.core.domain.model.RegisterBody;
import com.hlzt.common.utils.ServletUtils;
import com.hlzt.framework.web.service.SysLoginService;
import com.hlzt.framework.web.service.SysPermissionService;
import com.hlzt.framework.web.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 移动端登录验证
 *
 * @author slx
 */
@Api(value = "登录controller", tags = {"移动端登录"})
@RestController
@RequestMapping("/api/")
public class SysLoginApiController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 移动端登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @ApiOperation("获取用户信息")
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        Set<String> appPermissions = new HashSet<String>();
        if (permissions != null && permissions.size() > 0) {
            for (String permission : permissions) {
                if (permission.contains("app")) {
                    appPermissions.add(permission);
                }
            }
        }
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", appPermissions);
        return ajax;
    }

    @ApiOperation("单位注册")
    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody registerBody) {
        return AjaxResult.success(loginService.register(registerBody));
    }
}
