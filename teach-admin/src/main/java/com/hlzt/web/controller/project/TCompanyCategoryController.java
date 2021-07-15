package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.project.domain.TCompanyCategory;
import com.hlzt.project.service.ITCompanyCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位类型Controller
 *
 * @author slx
 * @date 2021-07-02
 */
@RestController
@RequestMapping("/project/company")
public class TCompanyCategoryController extends BaseController {
    @Autowired
    private ITCompanyCategoryService tCompanyCategoryService;

    /**
     * 查询单位类型列表
     */
    @PreAuthorize("@ss.hasPermi('project:company:list')")
    @GetMapping("/list")
    public AjaxResult list(TCompanyCategory tCompanyCategory) {
        List<TCompanyCategory> list = tCompanyCategoryService.selectTCompanyCategoryList(tCompanyCategory);
        return AjaxResult.success(list);
    }

    @GetMapping("/tree")
    public AjaxResult tree(TCompanyCategory tCompanyCategory) {
        List<TCompanyCategory> list = tCompanyCategoryService.selectTCompanyCategoryTree(tCompanyCategory);
        return AjaxResult.success(list);
    }

    /**
     * 导出单位类型列表
     */
    @PreAuthorize("@ss.hasPermi('project:company:export')")
    @Log(title = "单位类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TCompanyCategory tCompanyCategory) {
        List<TCompanyCategory> list = tCompanyCategoryService.selectTCompanyCategoryList(tCompanyCategory);
        ExcelUtil<TCompanyCategory> util = new ExcelUtil<TCompanyCategory>(TCompanyCategory.class);
        return util.exportExcel(list, "单位类型数据");
    }

    /**
     * 获取单位类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:company:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId) {
        return AjaxResult.success(tCompanyCategoryService.selectTCompanyCategoryById(companyId));
    }

    /**
     * 新增单位类型
     */
    @PreAuthorize("@ss.hasPermi('project:company:add')")
    @Log(title = "单位类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCompanyCategory tCompanyCategory) {
        TCompanyCategory info = tCompanyCategoryService.selectTCompanyCategoryByKeyName(tCompanyCategory.getKeyName());
        if (StringUtils.isNotNull(info)) {
            AjaxResult.error("关键词不能重复!");
        }
        return toAjax(tCompanyCategoryService.insertTCompanyCategory(tCompanyCategory));
    }

    /**
     * 修改单位类型
     */
    @PreAuthorize("@ss.hasPermi('project:company:edit')")
    @Log(title = "单位类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCompanyCategory tCompanyCategory) {
        TCompanyCategory info = tCompanyCategoryService.selectTCompanyCategoryByKeyName(tCompanyCategory.getKeyName());
        if (StringUtils.isNotNull(info) && info.getCompanyId().compareTo(tCompanyCategory.getCompanyId()) != 0) {
            AjaxResult.error("关键词不能重复!");
        }
        return toAjax(tCompanyCategoryService.updateTCompanyCategory(tCompanyCategory));
    }

    /**
     * 删除单位类型
     */
    @PreAuthorize("@ss.hasPermi('project:company:remove')")
    @Log(title = "单位类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds) {
        return toAjax(tCompanyCategoryService.deleteTCompanyCategoryByIds(companyIds));
    }
}
