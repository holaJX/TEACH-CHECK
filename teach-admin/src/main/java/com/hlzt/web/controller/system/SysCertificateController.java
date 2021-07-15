package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysCertificate;
import com.hlzt.system.service.ISysCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资格证信息Controller
 * 
 * @author dengyy
 * @date 2021-04-21
 */
@RestController
@RequestMapping("/system/certificate")
public class SysCertificateController extends BaseController
{
    @Autowired
    private ISysCertificateService sysCertificateService;

    /**
     * 查询资格证信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysCertificate sysCertificate)
    {
        startPage();
        List<SysCertificate> list = sysCertificateService.selectSysCertificateList(sysCertificate);
        return getDataTable(list);
    }

    /**
     * 导出资格证信息列表
     */
    @Log(title = "资格证信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCertificate sysCertificate)
    {
        List<SysCertificate> list = sysCertificateService.selectSysCertificateList(sysCertificate);
        ExcelUtil<SysCertificate> util = new ExcelUtil<SysCertificate>(SysCertificate.class);
        return util.exportExcel(list, "资格证信息数据");
    }

    /**
     * 获取资格证信息详细信息
     */
    @GetMapping(value = "/{certificateId}")
    public AjaxResult getInfo(@PathVariable("certificateId") Long certificateId)
    {
        return AjaxResult.success(sysCertificateService.selectSysCertificateById(certificateId));
    }

    /**
     * 新增资格证信息
     */
    @Log(title = "资格证信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCertificate sysCertificate)
    {
        return toAjax(sysCertificateService.insertSysCertificate(sysCertificate));
    }

    /**
     * 修改资格证信息
     */
    @Log(title = "资格证信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCertificate sysCertificate)
    {
        return toAjax(sysCertificateService.updateSysCertificate(sysCertificate));
    }

    /**
     * 删除资格证信息
     */
    @Log(title = "资格证信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{certificateIds}")
    public AjaxResult remove(@PathVariable Long[] certificateIds)
    {
        return toAjax(sysCertificateService.deleteSysCertificateByIds(certificateIds));
    }
}
