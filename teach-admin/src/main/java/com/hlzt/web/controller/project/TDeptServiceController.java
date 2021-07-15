package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.project.domain.TDeptService;
import com.hlzt.project.service.ITDeptServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务机构Controller
 * 
 * @author slx
 * @date 2021-07-02
 */
@RestController
@RequestMapping("/project/deptService")
public class TDeptServiceController extends BaseController {
    @Autowired
    private ITDeptServiceService tDeptServiceService;

    /**
     * 查询服务机构列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TDeptService tDeptService)
    {
        startPage();
        List<TDeptService> list = tDeptServiceService.selectTDeptServiceList(tDeptService);
        return getDataTable(list);
    }

    /**
     * 导出服务机构列表
     */
    @Log(title = "服务机构", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TDeptService tDeptService)
    {
        List<TDeptService> list = tDeptServiceService.selectTDeptServiceList(tDeptService);
        ExcelUtil<TDeptService> util = new ExcelUtil<TDeptService>(TDeptService.class);
        return util.exportExcel(list, "服务机构数据");
    }

    /**
     * 获取服务机构详细信息
     */
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(tDeptServiceService.selectTDeptServiceById(deptId));
    }

    /**
     * 新增服务机构
     */
    @Log(title = "服务机构", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDeptService tDeptService)
    {
        return toAjax(tDeptServiceService.insertTDeptService(tDeptService));
    }

    /**
     * 修改服务机构
     */
    @Log(title = "服务机构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDeptService tDeptService)
    {
        return toAjax(tDeptServiceService.updateTDeptService(tDeptService));
    }

    /**
     * 删除服务机构
     */
    @Log(title = "服务机构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(tDeptServiceService.deleteTDeptServiceByIds(deptIds));
    }
}
