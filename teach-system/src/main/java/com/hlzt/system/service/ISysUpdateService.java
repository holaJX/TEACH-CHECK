package com.hlzt.system.service;

import com.hlzt.system.domain.SysUpdate;

import java.util.List;

/**
 * 应用更新Service接口
 * 
 * @author slx
 * @date 2021-06-01
 */
public interface ISysUpdateService {
    /**
     * 查询应用更新
     * 
     * @param updateId 应用更新ID
     * @return 应用更新
     */
    public SysUpdate selectSysUpdateById(Long updateId);

    /**
     * 查询最新应用更新
     * @return
     */
    public SysUpdate getLast();

    /**
     * 查询应用更新列表
     * 
     * @param sysUpdate 应用更新
     * @return 应用更新集合
     */
    public List<SysUpdate> selectSysUpdateList(SysUpdate sysUpdate);

    /**
     * 新增应用更新
     * 
     * @param sysUpdate 应用更新
     * @return 结果
     */
    public int insertSysUpdate(SysUpdate sysUpdate);

    /**
     * 修改应用更新
     * 
     * @param sysUpdate 应用更新
     * @return 结果
     */
    public int updateSysUpdate(SysUpdate sysUpdate);

    /**
     * 批量删除应用更新
     * 
     * @param updateIds 需要删除的应用更新ID
     * @return 结果
     */
    public int deleteSysUpdateByIds(Long[] updateIds);

    /**
     * 删除应用更新信息
     * 
     * @param updateId 应用更新ID
     * @return 结果
     */
    public int deleteSysUpdateById(Long updateId);
}
