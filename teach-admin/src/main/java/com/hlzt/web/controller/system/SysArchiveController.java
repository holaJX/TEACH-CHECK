package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysArchive;
import com.hlzt.system.service.ISysArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文档管理Controller
 * 
 * @author dengyy
 * @date 2021-06-06
 */
@RestController
@RequestMapping("/system/archive")
public class SysArchiveController extends BaseController {
    @Autowired
    private ISysArchiveService sysArchiveService;

    /**
     * 查询文档管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:archive:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysArchive sysArchive)
    {
        startPage();
        List<SysArchive> list = sysArchiveService.selectSysArchiveList(sysArchive);
        return getDataTable(list);
    }

    /**
     * 导出文档管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:archive:export')")
    @Log(title = "文档管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysArchive sysArchive)
    {
        List<SysArchive> list = sysArchiveService.selectSysArchiveList(sysArchive);
        ExcelUtil<SysArchive> util = new ExcelUtil<SysArchive>(SysArchive.class);
        return util.exportExcel(list, "文档管理数据");
    }

    /**
     * 获取文档管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:archive:query')")
    @GetMapping(value = "/{archiveId}")
    public AjaxResult getInfo(@PathVariable("archiveId") Long archiveId)
    {
        return AjaxResult.success(sysArchiveService.selectSysArchiveById(archiveId));
    }

    /**
     * 新增文档管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:add')")
    @Log(title = "文档管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysArchive sysArchive)
    {
        return toAjax(sysArchiveService.insertSysArchive(sysArchive));
    }

    /**
     * 修改文档管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:edit')")
    @Log(title = "文档管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysArchive sysArchive)
    {
        return toAjax(sysArchiveService.updateSysArchive(sysArchive));
    }

    /**
     * 删除文档管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:remove')")
    @Log(title = "文档管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{archiveIds}")
    public AjaxResult remove(@PathVariable Long[] archiveIds)
    {
        return toAjax(sysArchiveService.deleteSysArchiveByIds(archiveIds));
    }
}
