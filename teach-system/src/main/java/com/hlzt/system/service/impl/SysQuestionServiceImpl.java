package com.hlzt.system.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.core.domain.entity.SysUser;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysQuestion;
import com.hlzt.system.mapper.SysQuestionMapper;
import com.hlzt.system.mapper.SysUserMapper;
import com.hlzt.system.service.ISysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 问题反馈Service业务层处理
 *
 * @author slx
 * @date 2021-06-01
 */
@Service
public class SysQuestionServiceImpl implements ISysQuestionService {
    @Autowired
    private SysQuestionMapper sysQuestionMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询问题反馈
     *
     * @param id 问题反馈ID
     * @return 问题反馈
     */
    @Override
    public SysQuestion selectSysQuestionById(Long id) {
        return sysQuestionMapper.selectSysQuestionById(id);
    }

    /**
     * 查询问题反馈列表
     *
     * @param sysQuestion 问题反馈
     * @return 问题反馈
     */
    @DataDictClass
    @Override
    public List<SysQuestion> selectSysQuestionList(SysQuestion sysQuestion) {
        List<SysQuestion> sysQuestionList = sysQuestionMapper.selectSysQuestionList(sysQuestion);
        sysQuestionList.forEach(sysQuestion1 -> {
            SysUser user = sysUserMapper.selectUserByUserName(sysQuestion1.getCreateBy());
            if (user != null) {
                sysQuestion1.setPhonenumber(user.getPhonenumber());
            }

        });
        return sysQuestionList;
    }

    /**
     * 新增问题反馈
     *
     * @param sysQuestion 问题反馈
     * @return 结果
     */
    @Override
    public int insertSysQuestion(SysQuestion sysQuestion) {
        sysQuestion.setCreateBy(SecurityUtils.getUsername());
        sysQuestion.setCreateTime(DateUtils.getNowDate());
        return sysQuestionMapper.insertSysQuestion(sysQuestion);
    }

    /**
     * 修改问题反馈
     *
     * @param sysQuestion 问题反馈
     * @return 结果
     */
    @Override
    public int updateSysQuestion(SysQuestion sysQuestion) {
        sysQuestion.setUpdateBy(SecurityUtils.getUsername());
        sysQuestion.setUpdateTime(DateUtils.getNowDate());
        return sysQuestionMapper.updateSysQuestion(sysQuestion);
    }

    /**
     * 批量删除问题反馈
     *
     * @param ids 需要删除的问题反馈ID
     * @return 结果
     */
    @Override
    public int deleteSysQuestionByIds(Long[] ids) {
        return sysQuestionMapper.deleteSysQuestionByIds(ids);
    }

    /**
     * 删除问题反馈信息
     *
     * @param id 问题反馈ID
     * @return 结果
     */
    @Override
    public int deleteSysQuestionById(Long id) {
        return sysQuestionMapper.deleteSysQuestionById(id);
    }
}
