package com.hlzt.system.service.impl;

import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysArchive;
import com.hlzt.system.mapper.SysArchiveMapper;
import com.hlzt.system.service.ISysArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文档管理Service业务层处理
 *
 * @author dengyy
 * @date 2021-06-06
 */
@Service
public class SysArchiveServiceImpl implements ISysArchiveService {
    @Autowired
    private SysArchiveMapper sysArchiveMapper;

    /**
     * 查询文档管理
     *
     * @param archiveId 文档管理ID
     * @return 文档管理
     */
    @Override
    public SysArchive selectSysArchiveById(Long archiveId) {
        return sysArchiveMapper.selectSysArchiveById(archiveId);
    }

    /**
     * 查询文档管理列表
     *
     * @param sysArchive 文档管理
     * @return 文档管理
     */
    @Override
    public List<SysArchive> selectSysArchiveList(SysArchive sysArchive) {
        return sysArchiveMapper.selectSysArchiveList(sysArchive);
    }

    /**
     * 新增文档管理
     *
     * @param sysArchive 文档管理
     * @return 结果
     */
    @Override
    public int insertSysArchive(SysArchive sysArchive) {
        sysArchive.setCreateBy(SecurityUtils.getUsername());
        sysArchive.setCreateTime(DateUtils.getNowDate());
        return sysArchiveMapper.insertSysArchive(sysArchive);
    }

    /**
     * 修改文档管理
     *
     * @param sysArchive 文档管理
     * @return 结果
     */
    @Override
    public int updateSysArchive(SysArchive sysArchive) {
        sysArchive.setUpdateBy(SecurityUtils.getUsername());
        sysArchive.setUpdateTime(DateUtils.getNowDate());
        return sysArchiveMapper.updateSysArchive(sysArchive);
    }

    /**
     * 批量删除文档管理
     *
     * @param archiveIds 需要删除的文档管理ID
     * @return 结果
     */
    @Override
    public int deleteSysArchiveByIds(Long[] archiveIds) {
        return sysArchiveMapper.deleteSysArchiveByIds(archiveIds);
    }

    /**
     * 删除文档管理信息
     *
     * @param archiveId 文档管理ID
     * @return 结果
     */
    @Override
    public int deleteSysArchiveById(Long archiveId) {
        return sysArchiveMapper.deleteSysArchiveById(archiveId);
    }
}
