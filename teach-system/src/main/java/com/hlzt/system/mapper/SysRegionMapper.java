package com.hlzt.system.mapper;

import java.util.List;
import java.util.Map;

import com.hlzt.system.domain.SysRegion;

/**
 * 行政区划Mapper接口
 * 
 * @author slx
 * @date 2021-04-23
 */
public interface SysRegionMapper 
{
    /**
     * 查询行政区划
     * 
     * @param id 行政区划ID
     * @return 行政区划
     */
    public SysRegion selectSysRegionById(Long id);

    /**
     * 查询行政区划列表
     * 
     * @param sysRegion 行政区划
     * @return 行政区划集合
     */
    public List<SysRegion> selectSysRegionList(SysRegion sysRegion);

    /**
     * 查询有多少子项
     *
     * @param parentId 父ID
     * @return 结果
     */
    public int selectSysRegionListNumber(Long parentId);

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
     * 删除行政区划
     * 
     * @param id 行政区划ID
     * @return 结果
     */
    public int deleteSysRegionById(Long id);

    /**
     * 批量删除行政区划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRegionByIds(Long[] ids);

    /**
     * 查询所有行政区划数据
     * @return
     */
    List<Map<String, Object>> selectAll();

    List<SysRegion> selectSysRegionListByAgencyId(Long agencyId);
}
