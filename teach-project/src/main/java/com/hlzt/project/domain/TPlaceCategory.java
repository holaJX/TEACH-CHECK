package com.hlzt.project.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.core.domain.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hlzt.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 部位类别对象 t_place_category
 * 
 * @author slx
 * @date 2021-07-02
 */
@Data
@ApiModel("部位类别")
public class TPlaceCategory extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /** 部位场所 */
    @ApiModelProperty(value = "ID")
    private Long placeId;

    /** 适用类别 */
    @Excel(name = "适用类别")
    @Dict(dictTable = "t_company_category", dictValue = "company_id", dictLabel = "key_name")
    @ApiModelProperty(value = "适用类别")
    private String companyType;
    private String companyTypeDictLabel;

    private String[] companyTypes;

    /** 部位场所描述 */
    @Excel(name = "部位场所描述")
    @ApiModelProperty(value = "部位场所描述")
    private String name;

    /** 是否公用 */
    @Excel(name = "是否公用")
    @Dict(dictValue = "sys_yes_no")
    @ApiModelProperty(value = "是否公用")
    private String isCommon;
    private String isCommonDictLabel;

    /** 等级 */
    @ApiModelProperty(value = "等级")
    private Long level;

    private Integer delFlag;

    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("placeId", getPlaceId())
            .append("parentId", getParentId())
            .append("companyType", getCompanyType())
            .append("name", getName())
            .append("isCommon", getIsCommon())
            .append("orderNum", getOrderNum())
            .append("ancestors", getAncestors())
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
