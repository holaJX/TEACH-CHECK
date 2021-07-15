package com.hlzt.web.controller.project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.project.domain.TStandardCategory;
import com.hlzt.project.service.ITStandardCategoryService;
import com.hlzt.common.utils.poi.ExcelUtil;

/**
 * 验收标准Controller
 * 
 * @author dengyy
 * @date 2021-07-05
 */
@RestController
@RequestMapping("/project/standard")
public class TStandardCategoryController extends BaseController {
    @Autowired
    private ITStandardCategoryService tStandardCategoryService;

    /**
     * 查询验收标准列表
     */
    @PreAuthorize("@ss.hasPermi('project:standard:list')")
    @GetMapping("/list")
    public AjaxResult list(TStandardCategory tStandardCategory)
    {
        List<TStandardCategory> list = tStandardCategoryService.selectTStandardCategoryList(tStandardCategory);
        return AjaxResult.success(list);
    }
    /**
     * 查询验收标准类型，适用对象
     */
    @PreAuthorize("@ss.hasPermi('project:standard:list')")
    @GetMapping("/getList")
    public AjaxResult getList(TStandardCategory tStandardCategory)
    {
        Set<String> standardTypes = new HashSet<>();
        Set<String> applyObjects = new HashSet<>();
        List<TStandardCategory> list = tStandardCategoryService.selectTStandardCategoryList(tStandardCategory);
        for (TStandardCategory standardCategory : list) {
            standardTypes.add(standardCategory.getStandardReference());
            applyObjects.addAll(Arrays.asList(standardCategory.getApplyProject()));
        }
        return AjaxResult.success(list);
    }

    
    /**
     * 导出验收标准列表
     */
    @PreAuthorize("@ss.hasPermi('project:standard:export')")
    @Log(title = "验收标准", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TStandardCategory tStandardCategory)
    {
        List<TStandardCategory> list = tStandardCategoryService.selectTStandardCategoryList(tStandardCategory);
        ExcelUtil<TStandardCategory> util = new ExcelUtil<TStandardCategory>(TStandardCategory.class);
        return util.exportExcel(list, "验收标准数据");
    }

    /**
     * 获取验收标准详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:standard:query')")
    @GetMapping(value = "/{standardId}")
    public AjaxResult getInfo(@PathVariable("standardId") Long standardId)
    {
        return AjaxResult.success(tStandardCategoryService.selectTStandardCategoryById(standardId));
    }

    /**
     * 新增验收标准
     */
    @PreAuthorize("@ss.hasPermi('project:standard:add')")
    @Log(title = "验收标准", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TStandardCategory tStandardCategory)
    {
        return toAjax(tStandardCategoryService.insertTStandardCategory(tStandardCategory));
    }

    /**
     * 修改验收标准
     */
    @PreAuthorize("@ss.hasPermi('project:standard:edit')")
    @Log(title = "验收标准", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TStandardCategory tStandardCategory)
    {
        return toAjax(tStandardCategoryService.updateTStandardCategory(tStandardCategory));
    }

    /**
     * 删除验收标准
     */
    @PreAuthorize("@ss.hasPermi('project:standard:remove')")
    @Log(title = "验收标准", businessType = BusinessType.DELETE)
	@DeleteMapping("/{standardIds}")
    public AjaxResult remove(@PathVariable Long[] standardIds)
    {
        return toAjax(tStandardCategoryService.deleteTStandardCategoryByIds(standardIds));
    }
}
