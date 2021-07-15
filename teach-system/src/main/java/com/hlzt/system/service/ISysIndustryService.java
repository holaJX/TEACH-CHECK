package com.hlzt.system.service;

import java.util.List;
import com.hlzt.system.domain.SysIndustry;

/**
 * 系统行业Service接口
 * 
 * @author slx
 * @date 2021-07-06
 */
public interface ISysIndustryService {
    /**
     * 查询系统行业
     * 
     * @param industryId 系统行业ID
     * @return 系统行业
     */
    public SysIndustry selectSysIndustryById(Long industryId);

    /**
     * 查询系统行业列表
     * 
     * @param sysIndustry 系统行业
     * @return 系统行业集合
     */
    public List<SysIndustry> selectSysIndustryList(SysIndustry sysIndustry);

    /**
     * 新增系统行业
     * 
     * @param sysIndustry 系统行业
     * @return 结果
     */
    public int insertSysIndustry(SysIndustry sysIndustry);

    /**
     * 修改系统行业
     * 
     * @param sysIndustry 系统行业
     * @return 结果
     */
    public int updateSysIndustry(SysIndustry sysIndustry);

    /**
     * 批量删除系统行业
     * 
     * @param industryIds 需要删除的系统行业ID
     * @return 结果
     */
    public int deleteSysIndustryByIds(Long[] industryIds);

    /**
     * 删除系统行业信息
     * 
     * @param industryId 系统行业ID
     * @return 结果
     */
    public int deleteSysIndustryById(Long industryId);
}
