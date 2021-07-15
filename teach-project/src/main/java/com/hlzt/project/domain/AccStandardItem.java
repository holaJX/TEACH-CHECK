package com.hlzt.project.domain;

import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 验收标准子项对象 t_standard_item
 *
 * @author slx
 * @date 2021-04-27
 */
@Data
@ApiModel("验收标准内容")
public class AccStandardItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 验收子项id
     */

    @ApiModelProperty(value = "标准类型")
    private Long itemId;

    /**
     * 验收项节点id（第三级）
     */
    @Excel(name = "验收项节点id", readConverterExp = "第=三级")
    @ApiModelProperty(value = "验收项节点id")
    private Long demandId;

    /**
     * 名称
     */
    @Excel(name = "名称")
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     */
    @Excel(name = "描述")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 子项限制最小值
     */
    @Excel(name = "子项限制最小值（包含）")
    @ApiModelProperty(value = "子项限制最小值（包含）")
    private String limitMinValue;

    /**
     * 子项限制最大值（不包含）
     */
    @Excel(name = "子项限制最大值（不包含）")
    @ApiModelProperty(value = "子项限制最大值（不包含）")
    private String limitMaxValue;

    /**
     * 子项限制单位
     */
    @Excel(name = "子项限制单位")
    @ApiModelProperty(value = "子项限制单位")
    private String limitUnit;

    /**
     * 子项限制等级
     */
    @Excel(name = "子项限制等级")
    @ApiModelProperty(value = "子项限制等级")
    private String limitLevel;


    private Integer delFlag;


    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("itemId", getItemId())
                .append("demandId", getDemandId())
                .append("name", getName())
                .append("description", getDescription())
                .append("limitMinValue", getLimitMinValue())
                .append("limitMaxValue", getLimitMaxValue())
                .append("limitUnit", getLimitUnit())
                .append("limitLevel", getLimitLevel())
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
