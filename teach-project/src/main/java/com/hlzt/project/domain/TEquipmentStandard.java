package com.hlzt.project.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设施标准关联对象 t_equipment_standard
 *
 * @author slx
 * @date 2021-05-14
 */
@Accessors(chain = true)
@Data
@ApiModel("设施标准关联")
public class TEquipmentStandard {
    private static final long serialVersionUID = 1L;

    /**
     * 设施ID
     */
    @ApiModelProperty(value = "设施ID")
    private Long equipmentId;

    /**
     * 标准ID
     */
    @ApiModelProperty(value = "标准ID")
    private Long standardId;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("equipmentId" , getEquipmentId())
                .append("standardId" , getStandardId())
                .toString();
    }
}
