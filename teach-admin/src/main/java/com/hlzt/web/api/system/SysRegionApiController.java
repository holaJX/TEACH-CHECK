package com.hlzt.web.api.system;

import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.system.domain.SysRegion;
import com.hlzt.system.service.ISysRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行政区划Controller
 *
 * @author slx
 * @date 2021-04-23
 */
@Api(value="行政区划Controller",tags={"行政区划"})
@RestController
@RequestMapping("/api/system/region")
public class SysRegionApiController extends BaseController {
    @Autowired
    private ISysRegionService sysRegionService;

    /**
     * 查询行政区划列表
     */
    @ApiOperation("查询行政区划列表(联动查询)")
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


    @ApiOperation("获取行政区划树信息，传 agencyId=53 ")
    @GetMapping("/regionTree")
    public AjaxResult getRegionTree(SysRegion sysRegion) {
        if (sysRegion.getParentId() == null) {
            sysRegion.setParentId(0L);
        }
        List<SysRegion> list = sysRegionService.selectSysRegionListByAgencyId(sysRegion.getAgencyId());
        return AjaxResult.success(list);
    }

    /**
     * 获取行政区划详细信息
     */
    @ApiOperation("获取行政区划详细信息")
    @ApiImplicitParam(name = "parentId", value = "行政区划ID",required = true, dataType = "Long", dataTypeClass = Long.class, paramType = "path")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysRegionService.selectSysRegionById(id));
    }
}
