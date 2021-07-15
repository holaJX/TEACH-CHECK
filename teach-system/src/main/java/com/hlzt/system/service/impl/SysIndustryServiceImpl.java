package com.hlzt.system.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysIndustry;
import com.hlzt.system.mapper.SysIndustryMapper;
import com.hlzt.system.service.ISysIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统行业Service业务层处理
 *
 * @author slx
 * @date 2021-07-06
 */
@Service
public class SysIndustryServiceImpl implements ISysIndustryService {
    @Autowired
    private SysIndustryMapper sysIndustryMapper;

    /**
     * 查询系统行业
     *
     * @param industryId 系统行业ID
     * @return 系统行业
     */
    @DataDictClass
    @Override
    public SysIndustry selectSysIndustryById(Long industryId) {
        return sysIndustryMapper.selectSysIndustryById(industryId);
    }

    /**
     * 查询系统行业列表
     *
     * @param sysIndustry 系统行业
     * @return 系统行业
     */
    @DataDictClass
    @Override
    public List<SysIndustry> selectSysIndustryList(SysIndustry sysIndustry) {
        return sysIndustryMapper.selectSysIndustryList(sysIndustry);
    }

    /**
     * 新增系统行业
     *
     * @param sysIndustry 系统行业
     * @return 结果
     */
    @Override
    public int insertSysIndustry(SysIndustry sysIndustry) {
        sysIndustry.setCreateBy(SecurityUtils.getUsername());
        sysIndustry.setCreateTime(DateUtils.getNowDate());
        return sysIndustryMapper.insertSysIndustry(sysIndustry);
    }

    /**
     * 修改系统行业
     *
     * @param sysIndustry 系统行业
     * @return 结果
     */
    @Override
    public int updateSysIndustry(SysIndustry sysIndustry) {
        sysIndustry.setUpdateBy(SecurityUtils.getUsername());
        sysIndustry.setUpdateTime(DateUtils.getNowDate());
        return sysIndustryMapper.updateSysIndustry(sysIndustry);
    }

    /**
     * 批量删除系统行业
     *
     * @param industryIds 需要删除的系统行业ID
     * @return 结果
     */
    @Override
    public int deleteSysIndustryByIds(Long[] industryIds) {
        return sysIndustryMapper.deleteSysIndustryByIds(industryIds);
    }

    /**
     * 删除系统行业信息
     *
     * @param industryId 系统行业ID
     * @return 结果
     */
    @Override
    public int deleteSysIndustryById(Long industryId) {
        return sysIndustryMapper.deleteSysIndustryById(industryId);
    }
}
