package com.hlzt.project.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hlzt.common.annotation.Excel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 任务配置对象 t_schedule_config
 * 
 * @author dyy
 * @date 2021-07-06
 */
@Data
@ApiModel("任务配置")
public class TScheduleConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 配置id */
    @ApiModelProperty(value = "${comment}")
    private Long scheduleId;

    /** 社会单位 */
    @Excel(name = "社会单位")
    @ApiModelProperty(value = "社会单位")
    private String deptId;

    /** 任务类型 */
    @Excel(name = "任务类型")
    @ApiModelProperty(value = "任务类型")
    private Long scheduleType;

    /** 任务名称 */
    @Excel(name = "任务名称")
    @ApiModelProperty(value = "任务名称")
    private String scheduleName;

    /** 频次 */
    @Excel(name = "频次")
    @ApiModelProperty(value = "频次")
    private String scheduleFrequency;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /** 安排人员 */
    @Excel(name = "安排人员")
    @ApiModelProperty(value = "安排人员")
    private String createUsername;

    /** 适用范围 */
    @Excel(name = "适用范围")
    @ApiModelProperty(value = "适用范围")
    private String applyRange;

    /** 适用标准 */
    @Excel(name = "适用标准")
    @ApiModelProperty(value = "适用标准")
    private String applyStandard;

    /** 适用对象 */
    @Excel(name = "适用对象")
    @ApiModelProperty(value = "适用对象")
    private String applyObject;

    /** $column.columnComment */
    @Excel(name = "适用对象")
    @ApiModelProperty(value = "适用对象")
    private Integer deleteFlag;

    /** $column.columnComment */
    @Excel(name = "适用对象")
    @ApiModelProperty(value = "适用对象")
    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("deptId", getDeptId())
            .append("scheduleType", getScheduleType())
            .append("scheduleName", getScheduleName())
            .append("scheduleFrequency", getScheduleFrequency())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createUsername", getCreateUsername())
            .append("applyRange", getApplyRange())
            .append("applyStandard", getApplyStandard())
            .append("applyObject", getApplyObject())
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
