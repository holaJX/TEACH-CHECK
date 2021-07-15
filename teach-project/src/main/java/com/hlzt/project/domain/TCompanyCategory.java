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
 * 单位类型对象 t_company_category
 * 
 * @author slx
 * @date 2021-07-02
 */
@Data
@ApiModel("单位类型")
public class TCompanyCategory extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /** 单位类型 */
    @ApiModelProperty(value = "ID")
    private Long companyId;

    /** 单位类型描述 */
    @Excel(name = "单位类型描述")
    @ApiModelProperty(value = "单位类型描述")
    private String name;

    /** 唯一关键词 */
    @Excel(name = "唯一关键词")
    @ApiModelProperty(value = "唯一关键词")
    private String keyName;

    /** 等级 */
    @ApiModelProperty(value = "等级")
    private Long level;

    /** $column.columnComment */
    private Integer delFlag;

    /** $column.columnComment */
    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("parentId", getParentId())
            .append("name", getName())
            .append("keyName", getKeyName())
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
