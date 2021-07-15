package com.hlzt.system.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 行政区划对象 sys_region
 *
 * @author slx
 * @date 2021-04-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "行政区划对象")
public class SysRegion extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    @Excel(name = "名称")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    @Dict(dictValue = "region_type")
    @Excel(name = "类型")
    private String type;
    private String typeDictLabel;

    /**
     * 区划代码
     */
    @ApiModelProperty("区划代码")
    @Excel(name = "区划代码")
    private Long agencyId;
    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 子部门
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(value = "子项")
    private List<?> children = new ArrayList<>();
    /**
     * 类型
     */
    @ApiModelProperty("是否有下一级")
    @Excel(name = "是否有下一级")
    private Boolean hasChildren;

    /**
     * 是不是叶子节点
     */
    private Boolean leaf;
}
