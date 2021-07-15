package com.hlzt.system.service.impl;

import com.hlzt.common.constant.UserConstants;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysUpdate;
import com.hlzt.system.mapper.SysUpdateMapper;
import com.hlzt.system.service.ISysUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用更新Service业务层处理
 *
 * @author slx
 * @date 2021-06-01
 */
@Service
public class SysUpdateServiceImpl implements ISysUpdateService {
    @Autowired
    private SysUpdateMapper sysUpdateMapper;

    /**
     * 查询应用更新
     *
     * @param updateId 应用更新ID
     * @return 应用更新
     */
    @Override
    public SysUpdate selectSysUpdateById(Long updateId) {
        return sysUpdateMapper.selectSysUpdateById(updateId);
    }

    @Override
    public SysUpdate getLast() {
        SysUpdate sysUpdate = new SysUpdate();
        sysUpdate.setIsLast(UserConstants.YES);
        List<SysUpdate> updates = sysUpdateMapper.selectSysUpdateList(sysUpdate);
        if (updates != null && updates.size() > 0) {
            return updates.get(0);
        }
        return null;
    }

    /**
     * 查询应用更新列表
     *
     * @param sysUpdate 应用更新
     * @return 应用更新
     */
    @Override
    public List<SysUpdate> selectSysUpdateList(SysUpdate sysUpdate) {
        return sysUpdateMapper.selectSysUpdateList(sysUpdate);
    }

    /**
     * 新增应用更新
     *
     * @param sysUpdate 应用更新
     * @return 结果
     */
    @Override
    public int insertSysUpdate(SysUpdate sysUpdate) {
        sysUpdate.setCreateBy(SecurityUtils.getUsername());
        sysUpdate.setCreateTime(DateUtils.getNowDate());
        return sysUpdateMapper.insertSysUpdate(sysUpdate);
    }

    /**
     * 修改应用更新
     *
     * @param sysUpdate 应用更新
     * @return 结果
     */
    @Override
    public int updateSysUpdate(SysUpdate sysUpdate) {
        sysUpdate.setUpdateBy(SecurityUtils.getUsername());
        sysUpdate.setUpdateTime(DateUtils.getNowDate());
        return sysUpdateMapper.updateSysUpdate(sysUpdate);
    }

    /**
     * 批量删除应用更新
     *
     * @param updateIds 需要删除的应用更新ID
     * @return 结果
     */
    @Override
    public int deleteSysUpdateByIds(Long[] updateIds) {
        return sysUpdateMapper.deleteSysUpdateByIds(updateIds);
    }

    /**
     * 删除应用更新信息
     *
     * @param updateId 应用更新ID
     * @return 结果
     */
    @Override
    public int deleteSysUpdateById(Long updateId) {
        return sysUpdateMapper.deleteSysUpdateById(updateId);
    }
}
