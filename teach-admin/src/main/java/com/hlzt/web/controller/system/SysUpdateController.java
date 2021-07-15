package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.constant.UserConstants;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysUpdate;
import com.hlzt.system.service.ISysUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应用更新Controller
 *
 * @author slx
 * @date 2021-06-01
 */
@RestController
@RequestMapping("/system/update")
public class SysUpdateController extends BaseController {
    @Autowired
    private ISysUpdateService sysUpdateService;

    /**
     * 查询应用更新列表
     */
    @PreAuthorize("@ss.hasPermi('system:update:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUpdate sysUpdate) {
        startPage();
        List<SysUpdate> list = sysUpdateService.selectSysUpdateList(sysUpdate);
        return getDataTable(list);
    }

    /**
     * 导出应用更新列表
     */
    @PreAuthorize("@ss.hasPermi('system:update:export')")
    @Log(title = "应用更新", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUpdate sysUpdate) {
        List<SysUpdate> list = sysUpdateService.selectSysUpdateList(sysUpdate);
        ExcelUtil<SysUpdate> util = new ExcelUtil<SysUpdate>(SysUpdate.class);
        return util.exportExcel(list, "应用更新数据");
    }

    /**
     * 获取应用更新详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:update:query')")
    @GetMapping(value = "/{updateId}")
    public AjaxResult getInfo(@PathVariable("updateId") Long updateId) {
        return AjaxResult.success(sysUpdateService.selectSysUpdateById(updateId));
    }

    /**
     * 新增应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:update:add')")
    @Log(title = "应用更新", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUpdate sysUpdate) {
        if (sysUpdateService.getLast() != null) {
            return AjaxResult.error("请先修改原有的最新版本为旧版！");
        }
        return toAjax(sysUpdateService.insertSysUpdate(sysUpdate));
    }

    /**
     * 修改应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:update:edit')")
    @Log(title = "应用更新", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUpdate sysUpdate) {
        SysUpdate lastUpdate = sysUpdateService.getLast();
        if (lastUpdate != null && !lastUpdate.getUpdateId().equals(sysUpdate.getUpdateId()) && sysUpdate.getIsLast().equals(UserConstants.YES)) {
            return AjaxResult.error("请先修改原有的最新版本为旧版！");
        }
        return toAjax(sysUpdateService.updateSysUpdate(sysUpdate));
    }

    /**
     * 删除应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:update:remove')")
    @Log(title = "应用更新", businessType = BusinessType.DELETE)
    @DeleteMapping("/{updateIds}")
    public AjaxResult remove(@PathVariable Long[] updateIds) {
        return toAjax(sysUpdateService.deleteSysUpdateByIds(updateIds));
    }
}
