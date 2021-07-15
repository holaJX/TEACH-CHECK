package com.hlzt.web.api.system;

import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.entity.SysDictData;
import com.hlzt.common.core.domain.entity.SysDictType;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.system.service.ISysDictDataService;
import com.hlzt.system.service.ISysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典信息
 *
 * @author ruo-yi
 */
@Api(value = "数据字典controller", tags = {"数据字典信息"})
@RestController
@RequestMapping("/api/system/dict/data")
public class SysDictDataApiController extends BaseController {

    @Autowired
    private ISysDictTypeService dictTypeService;
    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     */
    @ApiOperation("根据字典类型查询字典数据信息")
    @ApiImplicitParam(name = "dictType", value = "字典类型", dataType = "String", dataTypeClass = Boolean.class, paramType = "query")
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {
        List<SysDictData> data = dictTypeService.selectDictDataByType(dictType);
        if (StringUtils.isNull(data)) {
            data = new ArrayList<>();
        }
        return AjaxResult.success(data);
    }

    /**
     * 根据表类型查询表数据信息
     */
    @ApiOperation("根据表类型查询表数据信息")
    @ApiImplicitParam(name = "tableType", value = "字典表类型(三个字段用逗号分隔)", dataType = "String", dataTypeClass = Boolean.class, paramType = "query")
    @GetMapping(value = "/table/{tableType}")
    public AjaxResult dictTableType(@PathVariable String tableType) {
        String[] params = tableType.split(",");
        List<SysDictData> data = dictDataService.selectTableDictItems(params[0], params[1], params[2]);
        if (StringUtils.isNull(data)) {
            data = new ArrayList<>();
        }
        return AjaxResult.success(data);
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @ApiOperation("所有字典数据信息")
    @GetMapping(value = "/allData")
    public AjaxResult allData() {
        List<SysDictType> list = dictTypeService.selectDictTypeList(new SysDictType());
        list.forEach(sysDictType -> {
            List<SysDictData> dictData = dictTypeService.selectDictDataByType(sysDictType.getDictType());
            sysDictType.setDictData(dictData);
        });
        return AjaxResult.success(list);
    }

}
