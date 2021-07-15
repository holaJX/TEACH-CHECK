package com.hlzt.system.mapper;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.system.domain.SysArchive;

/**
 * 文档管理Mapper接口
 * 
 * @author dengyy
 * @date 2021-06-06
 */
public interface SysArchiveMapper extends Mapper<SysArchive>{
    /**
     * 查询文档管理
     * 
     * @param archiveId 文档管理ID
     * @return 文档管理
     */
    public SysArchive selectSysArchiveById(Long archiveId);

    /**
     * 查询文档管理列表
     * 
     * @param sysArchive 文档管理
     * @return 文档管理集合
     */
    public List<SysArchive> selectSysArchiveList(SysArchive sysArchive);

    /**
     * 新增文档管理
     * 
     * @param sysArchive 文档管理
     * @return 结果
     */
    public int insertSysArchive(SysArchive sysArchive);

    /**
     * 修改文档管理
     * 
     * @param sysArchive 文档管理
     * @return 结果
     */
    public int updateSysArchive(SysArchive sysArchive);

    /**
     * 删除文档管理
     * 
     * @param archiveId 文档管理ID
     * @return 结果
     */
    public int deleteSysArchiveById(Long archiveId);

    /**
     * 批量删除文档管理
     * 
     * @param archiveIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArchiveByIds(Long[] archiveIds);
}
