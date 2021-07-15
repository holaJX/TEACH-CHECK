package com.hlzt.web.controller.project;


import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.project.domain.TDeptConstruct;
import com.hlzt.project.service.ITDeptConstructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 建（构）筑物Controller
 * 
 * @author slx
 * @date 2021-07-02
 */
@RestController
@RequestMapping("/project/construct")
public class TDeptConstructController extends BaseController {
    @Autowired
    private ITDeptConstructService tDeptConstructService;

    /**
     * 查询建（构）筑物列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TDeptConstruct tDeptConstruct)
    {
        startPage();
        List<TDeptConstruct> list = tDeptConstructService.selectTDeptConstructList(tDeptConstruct);
        return getDataTable(list);
    }

    /**
     * 导出建（构）筑物列表
     */
    @Log(title = "建（构）筑物", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TDeptConstruct tDeptConstruct)
    {
        List<TDeptConstruct> list = tDeptConstructService.selectTDeptConstructList(tDeptConstruct);
        ExcelUtil<TDeptConstruct> util = new ExcelUtil<TDeptConstruct>(TDeptConstruct.class);
        return util.exportExcel(list, "建（构）筑物数据");
    }

    /**
     * 获取建（构）筑物详细信息
     */
    @GetMapping(value = "/{constructId}")
    public AjaxResult getInfo(@PathVariable("constructId") Long constructId)
    {
        return AjaxResult.success(tDeptConstructService.selectTDeptConstructById(constructId));
    }

    /**
     * 新增建（构）筑物
     */
    @Log(title = "建（构）筑物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDeptConstruct tDeptConstruct)
    {
        return toAjax(tDeptConstructService.insertTDeptConstruct(tDeptConstruct));
    }

    /**
     * 修改建（构）筑物
     */
    @Log(title = "建（构）筑物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDeptConstruct tDeptConstruct)
    {
        return toAjax(tDeptConstructService.updateTDeptConstruct(tDeptConstruct));
    }

    /**
     * 删除建（构）筑物
     */
    @Log(title = "建（构）筑物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{constructIds}")
    public AjaxResult remove(@PathVariable Long[] constructIds)
    {
        return toAjax(tDeptConstructService.deleteTDeptConstructByIds(constructIds));
    }
}
