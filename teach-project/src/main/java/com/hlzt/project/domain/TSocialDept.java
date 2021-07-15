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
 * 单位基本信息对象 t_social_dept
 *
 * @author slx
 * @date 2021-07-02
 */
@Data
@ApiModel("单位基本信息")
public class TSocialDept extends BaseEntity {
    private static final long serialVersionUID = 1L;



    /**
     * 部门id
     */
    @ApiModelProperty(value = "${comment}")
    private Long deptId;

    private Long socialDeptId;

    /**
     * 父部门id
     */
    @Excel(name = "父部门id")
    @ApiModelProperty(value = "父部门id")
    private Long parentId;

    /**
     * 祖级列表
     */
    @Excel(name = "祖级列表")
    @ApiModelProperty(value = "祖级列表")
    private String ancestors;

    /**
     * 服务机构
     */
    @Excel(name = "服务机构")
    @ApiModelProperty(value = "服务机构")
    private String serviceDeptIds;

    /**
     * 单位类型
     */
    @Excel(name = "单位类型")
    @ApiModelProperty(value = "单位类型")
    private String deptType;

    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 显示顺序
     */
    @Excel(name = "显示顺序")
    @ApiModelProperty(value = "显示顺序")
    private Long orderNum;

    /**
     * 负责人
     */
    @Excel(name = "负责人")
    @ApiModelProperty(value = "负责人")
    private String leader;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 行政区域代码
     */
    @Dict(dictTable = "sys_region", dictValue = "agency_id", dictLabel = "name")
    @ApiModelProperty("行政区域代码")
    private String districtCode;
    private String districtCodeDictLabel;

    /**
     * 详细地址
     */
    @Excel(name = "详细地址")
    @ApiModelProperty(value = "详细地址")
    @Dict(dictTable = "sys_region", dictValue = "agency_id", dictLabel = "name")
    private String detailedAddress;

    private String detailedAddressDictLabel;
    /**
     * 统一社会信用代码
     */
    @Excel(name = "统一社会信用代码")
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;

    /**
     * 上级名称
     */
    @Excel(name = "上级名称")
    @ApiModelProperty(value = "上级名称")
    private String parentName;

    /**
     * 行业类别
     */
    @Excel(name = "行业类别")
    @ApiModelProperty(value = "行业类别")
    @Dict(dictValue = "industry_type")
    private String industryType;


    private String industryTypeDictLabel;
    /**
     * 占地面积
     */
    @Excel(name = "占地面积")
    @ApiModelProperty(value = "占地面积")
    private BigDecimal coversArea;

    /**
     * 建筑面积
     */
    @Excel(name = "建筑面积")
    @ApiModelProperty(value = "建筑面积")
    private BigDecimal buildArea;

    /**
     * 职工人数
     */
    @Excel(name = "职工人数")
    @ApiModelProperty(value = "职工人数")
    private Long workerNum;

    /**
     * 消防监管
     */
    @Excel(name = "消防监管")
    @ApiModelProperty(value = "消防监管")
    private String fireSupervise;

    /**
     * 单位照片
     */
    @Excel(name = "单位照片")
    @ApiModelProperty(value = "单位照片")
    private String deptImage;

    /**
     * $column.columnComment
     */
    @ApiModelProperty(value = "单位照片")
    private Integer delFlag;

    /**
     * $column.columnComment
     */
    @Excel(name = "单位照片")
    @ApiModelProperty(value = "单位照片")
    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deptId", getDeptId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("serviceDeptIds", getServiceDeptIds())
                .append("deptType", getDeptType())
                .append("deptName", getDeptName())
                .append("orderNum", getOrderNum())
                .append("leader", getLeader())
                .append("phone", getPhone())
                .append("districtCode", getDistrictCode())
                .append("detailedAddress", getDetailedAddress())
                .append("creditCode", getCreditCode())
                .append("parentName", getParentName())
                .append("industryType", getIndustryType())
                .append("coversArea", getCoversArea())
                .append("buildArea", getBuildArea())
                .append("workerNum", getWorkerNum())
                .append("fireSupervise", getFireSupervise())
                .append("deptImage", getDeptImage())
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
