package com.hlzt.project.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 消防产品管理对象 t_fire_product
 * 
 * @author slx
 * @date 2021-06-02
 */
@Data
@Accessors(chain = true)
@ApiModel("消防产品管理")
public class TFireProduct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty(value = "${comment}")
    private Long fireProductId;

    /** 设备类型 */
    @Excel(name = "设备类型")
    @ApiModelProperty(value = "设备类型")
    @Dict(dictTable = "t_equipment_category",dictValue = "equipment_id",dictLabel = "name")
    private Long equipType;

    /** 生产厂商 */
    @Excel(name = "生产厂商")
    @ApiModelProperty(value = "生产厂商")
    private String manufacturer;

    /** 产品名称 */
    @Excel(name = "产品名称")
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /** 规格型号 */
    @Excel(name = "规格型号")
    @ApiModelProperty(value = "规格型号")
    private String specification;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fireProductId", getFireProductId())
            .append("equipType", getEquipType())
            .append("manufacturer", getManufacturer())
            .append("productName", getProductName())
            .append("specification", getSpecification())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
