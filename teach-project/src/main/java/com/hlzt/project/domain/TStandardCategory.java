package com.hlzt.project.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.core.domain.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import com.hlzt.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 验收标准对象 t_standard_category
 * 
 * @author dengyy
 * @date 2021-07-05
 */
@Data
@ApiModel("验收标准")
public class TStandardCategory extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value = "${comment}")
    private Long standardId;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty(value = "名称")
    private String name;

    /** 比重 */
    @Excel(name = "比重")
    @ApiModelProperty(value = "比重")
    private BigDecimal proportion;

    /** 引用标准 */
    @Excel(name = "引用标准")
    @ApiModelProperty(value = "引用标准")
    @Dict(dictValue = "current_standards")
    private String standardReference;

    private String standardReferenceDictLabel;

    /** 检查内容 */
    @Excel(name = "检查内容")
    @ApiModelProperty(value = "检查内容")
    private String acceptanceName;

    /** 关联监督检查 */
    @Excel(name = "关联监督检查")
    @ApiModelProperty(value = "关联监督检查")
    private String acceptanceSupervise;

    /** 等级 */
    @Excel(name = "等级")
    @ApiModelProperty(value = "等级")
    private Long level;

    /** 检查方法 */
    @Excel(name = "检查方法")
    @ApiModelProperty(value = "检查方法")
    private String acceptanceMethod;

    /** 记录模板 */
    @Excel(name = "记录模板")
    @ApiModelProperty(value = "记录模板")
    private String recordTemplate;

    /** 单位类型 */
    @Excel(name = "单位类型")
    @ApiModelProperty(value = "单位类型")
    private String deptType;

    /** 场所类型 */
    @Excel(name = "场所类型")
    @ApiModelProperty(value = "场所类型")
    private String placeType;

    /** 管理要求 */
    @Excel(name = "管理要求")
    @ApiModelProperty(value = "管理要求")
    private String technicalReq;

    /** 典型问题 */
    @Excel(name = "典型问题")
    @ApiModelProperty(value = "典型问题")
    private String typicalProblem;

    /** $column.columnComment */
    @ApiModelProperty(value = "典型问题")
    private Integer delFlag;

    /** $column.columnComment */
    @ApiModelProperty(value = "典型问题")
    private Long state;

    /** 适用项目 */
    @Excel(name = "适用项目")
    @ApiModelProperty(value = "适用项目")
    private String applyProject;

    /** 抽样要求 */
    @Excel(name = "抽样要求")
    @ApiModelProperty(value = "抽样要求")
    private String samplingReq;

    /** A项数 */
    @Excel(name = "A项数")
    @ApiModelProperty(value = "A项数")
    private Long levelACount;

    /** B项数 */
    @Excel(name = "B项数")
    @ApiModelProperty(value = "B项数")
    private Long levelBCount;

    /** C项数 */
    @Excel(name = "C项数")
    @ApiModelProperty(value = "C项数")
    private Long levelCCount;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("standardId", getStandardId())
            .append("parentId", getParentId())
            .append("name", getName())
            .append("proportion", getProportion())
            .append("standardReference", getStandardReference())
            .append("ancestors", getAncestors())
            .append("acceptanceName", getAcceptanceName())
            .append("orderNum", getOrderNum())
            .append("acceptanceSupervise", getAcceptanceSupervise())
            .append("level", getLevel())
            .append("acceptanceMethod", getAcceptanceMethod())
            .append("createBy", getCreateBy())
            .append("recordTemplate", getRecordTemplate())
            .append("createTime", getCreateTime())
            .append("deptType", getDeptType())
            .append("updateBy", getUpdateBy())
            .append("placeType", getPlaceType())
            .append("updateTime", getUpdateTime())
            .append("technicalReq", getTechnicalReq())
            .append("remark", getRemark())
            .append("typicalProblem", getTypicalProblem())
            .append("delFlag", getDelFlag())
            .append("state", getState())
            .append("applyProject", getApplyProject())
            .append("samplingReq", getSamplingReq())
            .append("levelACount", getLevelACount())
            .append("levelBCount", getLevelBCount())
            .append("levelCCount", getLevelCCount())
            .toString();
    }
}
