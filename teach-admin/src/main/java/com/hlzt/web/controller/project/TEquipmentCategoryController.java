package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.project.domain.TEquipmentCategory;
import com.hlzt.project.service.ITEquipmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 建筑消防设施Controller
 * 
 * @author slx
 * @date 2021-04-27
 */
@RestController
@RequestMapping("/project/equipment")
public class TEquipmentCategoryController extends BaseController {
    @Autowired
    private ITEquipmentCategoryService tEquipmentCategoryService;


    /**
     * 查询建筑消防设施列表
     */
    @DataDictClass
    @GetMapping("/getList")
    public TableDataInfo getList(TEquipmentCategory TEquipmentCategory)
    {
        startPage();
        List<TEquipmentCategory> list = tEquipmentCategoryService.selectList(TEquipmentCategory);
        return getDataTable(list);
    }

    /**
     * 查询建筑消防设施列表
     */
    @GetMapping("/list")
    public AjaxResult list(TEquipmentCategory TEquipmentCategory)
    {
        List<TEquipmentCategory> list = tEquipmentCategoryService.selectTEquipmentCategoryList(TEquipmentCategory);
        return AjaxResult.success(list);
    }

    /**
     * 获取设施下拉树列表
     */
    @GetMapping("/tree")
    public AjaxResult tree(TEquipmentCategory TEquipmentCategory)
    {
        List<TEquipmentCategory> list = tEquipmentCategoryService.selectTEquipmentCategoryList(TEquipmentCategory);
        return AjaxResult.success(tEquipmentCategoryService.buildTEquipmentCategoryTreeSelect(list));
    }

    /**
     * 导出建筑消防设施列表
     */
    @PreAuthorize("@ss.hasPermi('project:equipment:export')")
    @Log(title = "建筑消防设施", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TEquipmentCategory TEquipmentCategory)
    {
        List<TEquipmentCategory> list = tEquipmentCategoryService.selectTEquipmentCategoryList(TEquipmentCategory);
        ExcelUtil<TEquipmentCategory> util = new ExcelUtil<TEquipmentCategory>(TEquipmentCategory.class);
        return util.exportExcel(list, "建筑消防设施数据");
    }

    /**
     * 获取建筑消防设施详细信息
     */
    @DataDictClass(ObjClass = TEquipmentCategory.class)
    @GetMapping(value = "/{equipmentId}")
    public AjaxResult getInfo(@PathVariable("equipmentId") Long equipmentId)
    {
        return AjaxResult.success(tEquipmentCategoryService.selectTEquipmentCategoryById(equipmentId));
    }

    /**
     * 新增建筑消防设施
     */

    @Log(title = "建筑消防设施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEquipmentCategory TEquipmentCategory)
    {
        return toAjax(tEquipmentCategoryService.insertTEquipmentCategory(TEquipmentCategory));
    }

    /**
     * 修改建筑消防设施
     */
    @Log(title = "建筑消防设施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEquipmentCategory TEquipmentCategory)
    {
        return toAjax(tEquipmentCategoryService.updateTEquipmentCategory(TEquipmentCategory));
    }

    /**
     * 删除建筑消防设施
     */
    @Log(title = "建筑消防设施", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipmentIds}")
    public AjaxResult remove(@PathVariable Long[] equipmentIds)
    {
        return toAjax(tEquipmentCategoryService.deleteTEquipmentCategoryByIds(equipmentIds));
    }
}
