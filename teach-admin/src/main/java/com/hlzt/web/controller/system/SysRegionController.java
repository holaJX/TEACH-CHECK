package com.hlzt.web.controller.system;

import java.util.List;
import java.util.Map;

import com.hlzt.common.core.domain.ElTree;
import com.hlzt.common.core.redis.RedisCache;
import com.hlzt.common.utils.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import com.hlzt.system.domain.SysRegion;
import com.hlzt.system.service.ISysRegionService;
import com.hlzt.common.utils.poi.ExcelUtil;

/**
 * 行政区划Controller
 *
 * @author slx
 * @date 2021-04-23
 */
@RestController
@RequestMapping("/system/region")
public class SysRegionController extends BaseController {
    @Autowired
    private ISysRegionService sysRegionService;

    /**
     * 查询行政区划列表
     */
    @PreAuthorize("@ss.hasPermi('system:region:list')")
    @GetMapping("/list")
    public AjaxResult list(SysRegion sysRegion) {
        if (StringUtils.isEmpty(sysRegion.getType()) && sysRegion.getParentId() == null) {
            sysRegion.setParentId(0L);
        }
        List<SysRegion> list = null;
        if (sysRegion.getParentId() != null) {
            list = sysRegionService.selectSysRegionListByParentId(sysRegion.getParentId());
        } else {
            sysRegionService.selectSysRegionList(sysRegion);
        }

        return AjaxResult.success(list);
    }

    @GetMapping("/regionTree")
    public AjaxResult getRegionTree(SysRegion sysRegion) {
        if (sysRegion.getParentId() == null) {
            sysRegion.setParentId(0L);
        }
        List<SysRegion> list = sysRegionService.selectSysRegionListByAgencyId(sysRegion.getAgencyId());
        return AjaxResult.success(list);
    }


    /**
     * 导出行政区划列表
     */
    @PreAuthorize("@ss.hasPermi('system:region:export')")
    @Log(title = "行政区划", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRegion sysRegion) {
        List<SysRegion> list = sysRegionService.selectSysRegionList(sysRegion);
        ExcelUtil<SysRegion> util = new ExcelUtil<SysRegion>(SysRegion.class);
        return util.exportExcel(list, "行政区划数据");
    }

    /**
     * 获取行政区划详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:region:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysRegionService.selectSysRegionById(id));
    }

    /**
     * 新增行政区划
     */
    @PreAuthorize("@ss.hasPermi('system:region:add')")
    @Log(title = "行政区划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRegion sysRegion) {
        return toAjax(sysRegionService.insertSysRegion(sysRegion));
    }

    /**
     * 修改行政区划
     */
    @PreAuthorize("@ss.hasPermi('system:region:edit')")
    @Log(title = "行政区划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRegion sysRegion) {
        return toAjax(sysRegionService.updateSysRegion(sysRegion));
    }

    /**
     * 删除行政区划
     */
    @PreAuthorize("@ss.hasPermi('system:region:remove')")
    @Log(title = "行政区划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysRegionService.deleteSysRegionByIds(ids));
    }
}
