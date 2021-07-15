package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysIndustry;
import com.hlzt.system.service.ISysIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统行业Controller
 *
 * @author slx
 * @date 2021-07-06
 */
@RestController
@RequestMapping("/system/industry")
public class SysIndustryController extends BaseController {
    @Autowired
    private ISysIndustryService sysIndustryService;

    /**
     * 查询系统行业列表
     */
    @PreAuthorize("@ss.hasPermi('system:industry:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysIndustry sysIndustry) {
        startPage();
        List<SysIndustry> list = sysIndustryService.selectSysIndustryList(sysIndustry);
        return getDataTable(list);
    }

    /**
     * 导出系统行业列表
     */
    @PreAuthorize("@ss.hasPermi('system:industry:export')")
    @Log(title = "系统行业", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysIndustry sysIndustry) {
        List<SysIndustry> list = sysIndustryService.selectSysIndustryList(sysIndustry);
        ExcelUtil<SysIndustry> util = new ExcelUtil<SysIndustry>(SysIndustry.class);
        return util.exportExcel(list, "系统行业数据");
    }

    /**
     * 获取系统行业详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:industry:query')")
    @GetMapping(value = "/{industryId}")
    public AjaxResult getInfo(@PathVariable("industryId") Long industryId) {
        return AjaxResult.success(sysIndustryService.selectSysIndustryById(industryId));
    }

    /**
     * 新增系统行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:add')")
    @Log(title = "系统行业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysIndustry sysIndustry) {
        return toAjax(sysIndustryService.insertSysIndustry(sysIndustry));
    }

    /**
     * 修改系统行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:edit')")
    @Log(title = "系统行业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysIndustry sysIndustry) {
        return toAjax(sysIndustryService.updateSysIndustry(sysIndustry));
    }

    /**
     * 删除系统行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:remove')")
    @Log(title = "系统行业", businessType = BusinessType.DELETE)
    @DeleteMapping("/{industryIds}")
    public AjaxResult remove(@PathVariable Long[] industryIds) {
        return toAjax(sysIndustryService.deleteSysIndustryByIds(industryIds));
    }
}
