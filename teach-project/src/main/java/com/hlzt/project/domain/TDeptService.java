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
 * 服务机构对象 t_dept_service
 * 
 * @author slx
 * @date 2021-07-06
 */
@Data
@ApiModel("服务机构")
public class TDeptService extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 服务机构id */
    @Excel(name = "服务机构id")
    @ApiModelProperty(value = "服务机构id")
    private Long serviceId;

    /** 部门id */
    @ApiModelProperty(value = "服务机构id")
    private Long deptId;

    /** 执行部门 */
    @Excel(name = "执行部门")
    @ApiModelProperty(value = "执行部门")
    private Long doDeptId;

    /** 是否是服务机构来检查 */
    @Excel(name = "是否是服务机构来检查")
    @ApiModelProperty(value = "是否是服务机构来检查")
    private Long isService;

    /** 服务类型 */
    @Excel(name = "服务类型")
    @ApiModelProperty(value = "服务类型")
    private String serviceType;

    /** 服务机构名称 */
    @Excel(name = "服务机构名称")
    @ApiModelProperty(value = "服务机构名称")
    private String serviceName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    @ApiModelProperty(value = "显示顺序")
    private Long orderNum;

    /** 负责人 */
    @Excel(name = "负责人")
    @ApiModelProperty(value = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /** 设施范围 */
    @Excel(name = "设施范围")
    @ApiModelProperty(value = "设施范围")
    @Dict(dictTable = "t_equipment_category", dictValue = "equipment_id", dictLabel = "name")
    private String equipmentRange;

    private String equipmentRangeDictLabel;
    /** 检查类别 */
    @Excel(name = "检查类别")
    @ApiModelProperty(value = "检查类别")
    private String checkType;

    /** 服务开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Excel(name = "服务开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务开始时间")
    private Date startTime;

    /** 服务结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Excel(name = "服务结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务结束时间")
    private Date endTime;

    /** $column.columnComment */
    @ApiModelProperty(value = "服务结束时间")
    private Integer delFlag;

    /** $column.columnComment */
    @Excel(name = "服务结束时间")
    @ApiModelProperty(value = "服务结束时间")
    private Long state;

    /** 建筑范围 */
    @Excel(name = "建筑范围")
    @ApiModelProperty(value = "建筑范围")
    private String setAreaValue;

    /** 建筑范围 */
    @Excel(name = "建筑范围")
    @ApiModelProperty(value = "建筑范围")
    private String setAreaLabel;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("serviceId", getServiceId())
            .append("deptId", getDeptId())
            .append("doDeptId", getDoDeptId())
            .append("isService", getIsService())
            .append("serviceType", getServiceType())
            .append("serviceName", getServiceName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("equipmentRange", getEquipmentRange())
            .append("checkType", getCheckType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("state", getState())
            .append("setAreaValue", getSetAreaValue())
            .append("setAreaLabel", getSetAreaLabel())
            .toString();
    }
}
