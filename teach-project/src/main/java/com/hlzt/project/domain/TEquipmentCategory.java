package com.hlzt.project.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 建筑消防设施对象 t_equipment_category
 *
 * @author slx
 * @date 2021-04-27
 */
@Data
@ApiModel("建筑消防设施")
public class TEquipmentCategory extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 消防设施id
     */
    @ApiModelProperty(value = "ID")
    private Long equipmentId;

    /**
     * 设施类型
     */
    @Excel(name = "设施类型")
    @ApiModelProperty(value = "设施类型")
    @Dict(dictValue = "equipment_type")
    private String type;

    /**
     * 消防设施编号
     */
    @Excel(name = "消防设施编号")
    @ApiModelProperty(value = "消防设施编号")
    private String code;

    /**
     * 名称
     */
    @Excel(name = "名称")
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 单位
     */
    @Excel(name = "单位")
    @ApiModelProperty(value = "单位")
    @Dict(dictValue = "unit_type")
    private String unit;

    /**
     * 技术参数
     */
    @Excel(name = "技术参数")
    @ApiModelProperty(value = "技术参数")
    private String technicalData;

    /**
     * 等级
     */
    @Excel(name = "等级")
    @ApiModelProperty(value = "等级")
    private Long level;

    /**
     * $column.columnComment
     */
    private Integer delFlag;

    /**
     * $column.columnComment
     */
    private Long state;

    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 子部门
     */
    /**
     * 父菜单ID
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(value = "子项")
    private List<?> children = new ArrayList<>();


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("equipmentId", getEquipmentId())
                .append("parentId", getParentId())
                .append("code", getCode())
                .append("name", getName())
                .append("unit", getUnit())
                .append("technicalData", getTechnicalData())
                .append("orderNum", getOrderNum())
                .append("level", getLevel())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("state", getState())
                .toString();
    }
}
