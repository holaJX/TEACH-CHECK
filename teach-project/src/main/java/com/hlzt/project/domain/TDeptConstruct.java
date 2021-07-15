package com.hlzt.project.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import com.hlzt.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 建（构）筑物对象 t_dept_construct
 *
 * @author slx
 * @date 2021-07-02
 */
@Data
@ApiModel("建（构）筑物")
public class TDeptConstruct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 建构物id
     */
    @ApiModelProperty(value = "${comment}")
    private Long constructId;

    /**
     * 社会单位编号
     */
    @Excel(name = "社会单位编号")
    @ApiModelProperty(value = "社会单位编号")
    private Long deptId;

    /**
     * 建构物类型：0:单体1：储罐2：堆场 6：消防设施
     */
    @Excel(name = "建构物类型：0:单体1：储罐2：堆场 6：消防设施")
    @ApiModelProperty(value = "建构物类型：0:单体1：储罐2：堆场 6：消防设施")

    private Long constructType;

    /**
     * 使用性质
     */
    @Excel(name = "使用性质")
    @ApiModelProperty(value = "使用性质")
    @Dict(dictTable = "t_equipment_category", dictValue = "equipment_id", dictLabel = "name")
    private Long useNature;
    private  String useNatureDictLabel;

    /**
     * 建筑名称
     */
    @Excel(name = "建筑名称")
    @ApiModelProperty(value = "建筑名称")
    private String buildName;

    /**
     * 耐火等级
     */
    @Excel(name = "耐火等级")
    @ApiModelProperty(value = "耐火等级")
    @Dict(dictValue = "fire_resistance_level")
    private String refractoryLevel;
    private String refractoryLevelDictLabel;
    /**
     * 结构类型
     */
    @Excel(name = "结构类型")
    @ApiModelProperty(value = "结构类型")
    @Dict(dictValue = "structure_type")
    private String structureType;

    private String structureTypeDictLabel;
    /**
     * 地上层数
     */
    @Excel(name = "地上层数")
    @ApiModelProperty(value = "地上层数")
    private Long upperNumber;

    /**
     * 地下层数
     */
    @Excel(name = "地下层数")
    @ApiModelProperty(value = "地下层数")
    private Long underNumber;

    /**
     * 建筑高度
     */
    @Excel(name = "建筑高度")
    @ApiModelProperty(value = "建筑高度")
    private BigDecimal buildHeight;

    /**
     * 建筑长度
     */
    @Excel(name = "建筑长度")
    @ApiModelProperty(value = "建筑长度")
    private BigDecimal buildLength;

    /**
     * 建筑面积
     */
    @Excel(name = "建筑面积")
    @ApiModelProperty(value = "建筑面积")
    private BigDecimal coversArea;

    /**
     * 地上建筑面积
     */
    @Excel(name = "地上建筑面积")
    @ApiModelProperty(value = "地上建筑面积")
    private BigDecimal floorArea;

    /**
     * 地下建筑面积
     */
    @Excel(name = "地下建筑面积")
    @ApiModelProperty(value = "地下建筑面积")
    private BigDecimal underFloorArea;

    /**
     * 位置
     */
    @Excel(name = "位置")
    @ApiModelProperty(value = "位置")
    private String storagePosition;

    /**
     * 设置形式
     */
    @Excel(name = "设置形式")
    @ApiModelProperty(value = "设置形式")
    private String storageSetType;

    /**
     * 存储形式
     */
    @Excel(name = "存储形式")
    @ApiModelProperty(value = "存储形式")
    private String storageType;

    /**
     * 存储物质名称
     */
    @Excel(name = "存储物质名称")
    @ApiModelProperty(value = "存储物质名称")
    private String storageMaterialName;

    /**
     * 总容量
     */
    @Excel(name = "总容量")
    @ApiModelProperty(value = "总容量")
    private BigDecimal storageTotalCapacity;

    /**
     * 存储物质名称
     */
    @Excel(name = "存储物质名称")
    @ApiModelProperty(value = "存储物质名称")
    private String yardMaterialName;

    /**
     * 堆场名称
     */
    @Excel(name = "堆场名称")
    @ApiModelProperty(value = "堆场名称")
    private String yardName;

    /**
     * 堆场总容量
     */
    @Excel(name = "堆场总容量")
    @ApiModelProperty(value = "堆场总容量")
    private String yardTotalCapacity;

    /**
     * $column.columnComment
     */
    @Excel(name = "堆场总容量")
    @ApiModelProperty(value = "堆场总容量")
    private Integer deleteFlag;

    /**
     * $column.columnComment
     */
    @Excel(name = "堆场总容量")
    @ApiModelProperty(value = "堆场总容量")
    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("constructId", getConstructId())
                .append("deptId", getDeptId())
                .append("constructType", getConstructType())
                .append("useNature", getUseNature())
                .append("buildName", getBuildName())
                .append("refractoryLevel", getRefractoryLevel())
                .append("structureType", getStructureType())
                .append("upperNumber", getUpperNumber())
                .append("underNumber", getUnderNumber())
                .append("buildHeight", getBuildHeight())
                .append("buildLength", getBuildLength())
                .append("coversArea", getCoversArea())
                .append("floorArea", getFloorArea())
                .append("underFloorArea", getUnderFloorArea())
                .append("storagePosition", getStoragePosition())
                .append("storageSetType", getStorageSetType())
                .append("storageType", getStorageType())
                .append("storageMaterialName", getStorageMaterialName())
                .append("storageTotalCapacity", getStorageTotalCapacity())
                .append("yardMaterialName", getYardMaterialName())
                .append("yardName", getYardName())
                .append("yardTotalCapacity", getYardTotalCapacity())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("deleteFlag", getDeleteFlag())
                .append("state", getState())
                .toString();
    }
}
