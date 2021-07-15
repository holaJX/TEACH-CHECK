package com.hlzt.system.service.impl;

import com.hlzt.common.constant.CacheConstant;
import com.hlzt.common.utils.TreeUtil;
import com.hlzt.system.domain.SysRegion;
import com.hlzt.system.mapper.SysRegionMapper;
import com.hlzt.system.service.ISysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 行政区划Service业务层处理
 *
 * @author slx
 * @date 2021-04-23
 */
@Service
public class SysRegionServiceImpl implements ISysRegionService {
    @Autowired
    private SysRegionMapper sysRegionMapper;

    /**
     * 查询行政区划
     *
     * @param id 行政区划ID
     * @return 行政区划
     */
    @Override
    public SysRegion selectSysRegionById(Long id) {
        return sysRegionMapper.selectSysRegionById(id);
    }

    @Cacheable(value = CacheConstant.REGION, key = "#parentId")
    @Override
    public List<SysRegion> selectSysRegionListByParentId(Long parentId) {
        SysRegion sysRegion = new SysRegion();
        sysRegion.setParentId(parentId);
        List<SysRegion> regions = sysRegionMapper.selectSysRegionList(sysRegion);
        regions.forEach(region -> {
            int number = sysRegionMapper.selectSysRegionListNumber(region.getId());
            region.setHasChildren(number > 0);
        });
        return regions;
    }

    /**
     * 查询行政区划列表
     *
     * @param sysRegion 行政区划
     * @return 行政区划
     */
    @Override
    public List<SysRegion> selectSysRegionList(SysRegion sysRegion) {
        List<SysRegion> regions = sysRegionMapper.selectSysRegionList(sysRegion);
        regions.forEach(region -> {
            int number = sysRegionMapper.selectSysRegionListNumber(region.getId());
            region.setHasChildren(number > 0);
        });
        return regions;
    }

    /**
     * 新增行政区划
     *
     * @param sysRegion 行政区划
     * @return 结果
     */
    @CacheEvict(value = CacheConstant.REGION, key = "#sysRegion.getParentId()")
    @Override
    public int insertSysRegion(SysRegion sysRegion) {
        return sysRegionMapper.insertSysRegion(sysRegion);
    }

    /**
     * 修改行政区划
     *
     * @param sysRegion 行政区划
     * @return 结果
     */
    @CacheEvict(value = CacheConstant.REGION, key = "#sysRegion.getParentId()")
    @Override
    public int updateSysRegion(SysRegion sysRegion) {
        return sysRegionMapper.updateSysRegion(sysRegion);
    }

    /**
     * 批量删除行政区划
     *
     * @param ids 需要删除的行政区划ID
     * @return 结果
     */
    @CacheEvict(value = CacheConstant.REGION, allEntries = true)
    @Override
    public int deleteSysRegionByIds(Long[] ids) {
        return sysRegionMapper.deleteSysRegionByIds(ids);
    }

    /**
     * 删除行政区划信息
     *
     * @param id 行政区划ID
     * @return 结果
     */
    @CacheEvict(value = CacheConstant.REGION, allEntries = true)
    @Override
    public int deleteSysRegionById(Long id) {
        return sysRegionMapper.deleteSysRegionById(id);
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        return sysRegionMapper.selectAll();
    }

    @Cacheable(value = CacheConstant.REGION, key = "#agencyId")
    @Override
    public List<SysRegion> selectSysRegionListByAgencyId(Long agencyId) {
        List<SysRegion> sysRegions = sysRegionMapper.selectSysRegionListByAgencyId(agencyId);
        for (SysRegion sysRegion : sysRegions) {
            sysRegion.setLeaf(String.valueOf(sysRegion.getAgencyId()).length() >= 6);
        }
        return TreeUtil.createTree(sysRegions);
    }
}
