package com.hlzt.web.controller.project;

import java.util.List;
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
import com.hlzt.project.domain.TPlaceCategory;
import com.hlzt.project.service.ITPlaceCategoryService;
import com.hlzt.common.utils.poi.ExcelUtil;

/**
 * 部位类别Controller
 * 
 * @author slx
 * @date 2021-07-02
 */
@RestController
@RequestMapping("/project/place")
public class TPlaceCategoryController extends BaseController {
    @Autowired
    private ITPlaceCategoryService tPlaceCategoryService;

    /**
     * 查询部位类别列表
     */
    @PreAuthorize("@ss.hasPermi('project:place:list')")
    @GetMapping("/list")
    public AjaxResult list(TPlaceCategory tPlaceCategory)
    {
        List<TPlaceCategory> list = tPlaceCategoryService.selectTPlaceCategoryList(tPlaceCategory);
        return AjaxResult.success(list);
    }

    /**
     * 查询所有部位类别列表
     */
    @GetMapping("/tree")
    public AjaxResult tree(TPlaceCategory tPlaceCategory)
    {
        tPlaceCategory.setIsCommon("Y");
        List<TPlaceCategory> list = tPlaceCategoryService.selectTPlaceCategoryTree(tPlaceCategory);
        return AjaxResult.success(list);
    }

    /**
     * 导出部位类别列表
     */
    @PreAuthorize("@ss.hasPermi('project:place:export')")
    @Log(title = "部位类别", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TPlaceCategory tPlaceCategory)
    {
        List<TPlaceCategory> list = tPlaceCategoryService.selectTPlaceCategoryList(tPlaceCategory);
        ExcelUtil<TPlaceCategory> util = new ExcelUtil<TPlaceCategory>(TPlaceCategory.class);
        return util.exportExcel(list, "部位类别数据");
    }

    /**
     * 获取部位类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:place:query')")
    @GetMapping(value = "/{placeId}")
    public AjaxResult getInfo(@PathVariable("placeId") Long placeId)
    {
        return AjaxResult.success(tPlaceCategoryService.selectTPlaceCategoryById(placeId));
    }

    /**
     * 新增部位类别
     */
    @PreAuthorize("@ss.hasPermi('project:place:add')")
    @Log(title = "部位类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPlaceCategory tPlaceCategory)
    {
        return toAjax(tPlaceCategoryService.insertTPlaceCategory(tPlaceCategory));
    }

    /**
     * 修改部位类别
     */
    @PreAuthorize("@ss.hasPermi('project:place:edit')")
    @Log(title = "部位类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPlaceCategory tPlaceCategory)
    {
        return toAjax(tPlaceCategoryService.updateTPlaceCategory(tPlaceCategory));
    }

    /**
     * 删除部位类别
     */
    @PreAuthorize("@ss.hasPermi('project:place:remove')")
    @Log(title = "部位类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{placeIds}")
    public AjaxResult remove(@PathVariable Long[] placeIds)
    {
        return toAjax(tPlaceCategoryService.deleteTPlaceCategoryByIds(placeIds));
    }
}
