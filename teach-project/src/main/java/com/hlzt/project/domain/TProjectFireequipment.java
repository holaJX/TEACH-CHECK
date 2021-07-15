package com.hlzt.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 工程消防设施对象 t_project_fireequipment
 *
 * @author slx
 * @date 2021-05-07
 */
@Data
@ApiModel("工程消防设施")
public class TProjectFireequipment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 消防设施id */
    @ApiModelProperty(value = "ID")
    private Long fireEquipmentId;

    /** 项目工程id */
    @ApiModelProperty(value = "社会单位id")
    private Long deptId;

    /** 使用性质 */
    @Excel(name = "使用性质")
    @ApiModelProperty(value = "使用性质")
    @Dict(dictTable = "t_equipment_category",dictValue = "equipment_id",dictLabel = "name")
    private Long useNature;

    /** 设施类型 */
    @Excel(name = "设施类型")
    @ApiModelProperty(value = "设施类型")
    @Dict(dictTable = "t_equipment_category",dictValue = "equipment_id",dictLabel = "name")
    private String equipmentCategoryId;

    private  String equipmentCategoryIdDictLabel;
    /** 生产厂家 */
    @Excel(name = "生产厂家")
    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    /** 设施名称 */
    @Excel(name = "设施名称")
    @ApiModelProperty(value = "设施名称")
    private String equipmentName;

    /** 产品规格 */
    @Excel(name = "产品规格")
    @ApiModelProperty(value = "产品规格")
    private String specification;

    /** 设置数量 */
    @Excel(name = "设置数量")
    @ApiModelProperty(value = "设置数量")
    private Long setNumber;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "出厂日期")
    private Date productDate;

    /** 设置位置 */
    @Excel(name = "设置位置")
    @ApiModelProperty(value = "设置位置")
    private String setLocation;

    /** 技术参数 */
    @Excel(name = "技术参数")
    @ApiModelProperty(value = "技术参数")
    private String technicalParameter;

    /** 设置区域 */
    @Excel(name = "设置区域")
    @ApiModelProperty(value = "设置区域")
    private String setAreaValue;

    /** 设置区域 */
    @Excel(name = "设置区域")
    @ApiModelProperty(value = "设置区域")
    private String setAreaLabel;

    /** 现场图片 */
    @ApiModelProperty(value = "现场图片")
    private String imageUrl;

    /** 建筑类型 */
    @ApiModelProperty(value = "建筑类型")
    private String type;

    private Integer delFlag;

    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("fireEquipmentId", getFireEquipmentId())
                .append("deptId", getDeptId())
                .append("useNature", getUseNature())
                .append("equipmentCategoryId", getEquipmentCategoryId())
                .append("manufacturer", getManufacturer())
                .append("equipmentName", getEquipmentName())
                .append("specification", getSpecification())
                .append("setNumber", getSetNumber())
                .append("productDate", getProductDate())
                .append("setLocation", getSetLocation())
                .append("technicalParameter", getTechnicalParameter())
                .append("setAreaValue", getSetAreaValue())
                .append("imageUrl", getImageUrl())
                .append("createBy", getCreateBy())
                .append("type", getType())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("state", getState())
                .toString();
    }
}
