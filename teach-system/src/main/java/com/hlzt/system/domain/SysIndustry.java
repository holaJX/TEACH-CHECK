package com.hlzt.system.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 系统行业对象 sys_industry
 *
 * @author slx
 * @date 2021-07-06
 */
@Data
@ApiModel("系统行业")
public class SysIndustry extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 行业ID
     */
    @ApiModelProperty(value = "ID")
    private Long industryId;

    /**
     * 行业名称
     */
    @Excel(name = "行业名称")
    @ApiModelProperty(value = "行业名称")
    private String name;

    /**
     * 主管单位
     */
    @Excel(name = "主管单位")
    @ApiModelProperty(value = "主管单位")
    @Dict(dictTable = "sys_dept", dictValue = "dept_id", dictLabel = "dept_name")
    private String deptIds;
    private String deptIdsDictLabel;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("industryId", getIndustryId())
                .append("name", getName())
                .append("deptIds", getDeptIds())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
