package com.hlzt.system.service;

import java.util.List;
import java.util.Map;

import com.hlzt.system.domain.SysRegion;

/**
 * 行政区划Service接口
 * 
 * @author slx
 * @date 2021-04-23
 */
public interface ISysRegionService 
{
    /**
     * 查询行政区划
     * 
     * @param id 行政区划ID
     * @return 行政区划
     */
    public SysRegion selectSysRegionById(Long id);

    /**
     * 查询子行政区划列表
     * @param parentId 父ID
     * @return
     */
    public List<SysRegion> selectSysRegionListByParentId(Long parentId);

    /**
     * 查询行政区划列表
     * 
     * @param sysRegion 行政区划
     * @return 行政区划集合
     */
    public List<SysRegion> selectSysRegionList(SysRegion sysRegion);

    /**
     * 新增行政区划
     * 
     * @param sysRegion 行政区划
     * @return 结果
     */
    public int insertSysRegion(SysRegion sysRegion);

    /**
     * 修改行政区划
     * 
     * @param sysRegion 行政区划
     * @return 结果
     */
    public int updateSysRegion(SysRegion sysRegion);

    /**
     * 批量删除行政区划
     * 
     * @param ids 需要删除的行政区划ID
     * @return 结果
     */
    public int deleteSysRegionByIds(Long[] ids);

    /**
     * 删除行政区划信息
     * 
     * @param id 行政区划ID
     * @return 结果
     */
    public int deleteSysRegionById(Long id);

    /**
     * 查询所有行政区划数据
     * @return
     */
    List<Map<String, Object>> selectAll();

    List<SysRegion> selectSysRegionListByAgencyId(Long agencyId);
}
