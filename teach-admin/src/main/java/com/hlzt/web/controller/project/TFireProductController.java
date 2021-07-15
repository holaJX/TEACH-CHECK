package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TFireProduct;
import com.hlzt.project.service.ITFireProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消防产品管理Controller
 * 
 * @author slx
 * @date 2021-06-02
 */
@RestController
@RequestMapping("/project/tfireproduct")
public class TFireProductController extends BaseController {
    @Autowired
    private ITFireProductService TFireProductService;

    /**
     * 查询消防产品管理列表
     */
//    @PreAuthorize("@ss.hasPermi('project:TFireProduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFireProduct TFireProduct)
    {
        startPage();
        List<TFireProduct> list = TFireProductService.selectTFireProductList(TFireProduct);
        return getDataTable(list);
    }

    /**
     * 导出消防产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('project:TFireProduct:export')")
    @Log(title = "消防产品管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TFireProduct TFireProduct)
    {
        List<TFireProduct> list = TFireProductService.selectTFireProductList(TFireProduct);
        ExcelUtil<TFireProduct> util = new ExcelUtil<TFireProduct>(TFireProduct.class);
        return util.exportExcel(list, "消防产品管理数据");
    }

    /**
     * 获取消防产品管理详细信息
     */
	@DataDictClass(ObjClass = TFireProduct.class)
//    @PreAuthorize("@ss.hasPermi('project:TFireProduct:query')")
    @GetMapping(value = "/{fireProductId}")
    public AjaxResult getInfo(@PathVariable("fireProductId") Long fireProductId)
    {
        return AjaxResult.success(TFireProductService.selectTFireProductById(fireProductId));
    }

    /**
     * 新增消防产品管理
     */
//    @PreAuthorize("@ss.hasPermi('project:TFireProduct:add')")
    @Log(title = "消防产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFireProduct TFireProduct)
    {
        TFireProduct.setFireProductId(IdUtils.getNextId());
        return toAjax(TFireProductService.insertTFireProduct(TFireProduct));
    }

    /**
     * 修改消防产品管理
     */
//    @PreAuthorize("@ss.hasPermi('project:TFireProduct:edit')")
    @Log(title = "消防产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFireProduct TFireProduct)
    {
        return toAjax(TFireProductService.updateTFireProduct(TFireProduct));
    }

    /**
     * 删除消防产品管理
     */
    @Log(title = "消防产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fireProductIds}")
    public AjaxResult remove(@PathVariable Long[] fireProductIds)
    {
        return toAjax(TFireProductService.deleteTFireProductByIds(fireProductIds));
    }
}
