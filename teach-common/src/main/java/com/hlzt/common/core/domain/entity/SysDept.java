package com.hlzt.common.core.domain.entity;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.SensitiveInfo;
import com.hlzt.common.core.domain.BaseEntity;
import com.hlzt.common.enums.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门表 sys_dept
 *
 * @author ruo-yi
 */
@ApiModel("部门表")
public class SysDept extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private Long deptId;

    /**
     * 父部门ID
     */
    @ApiModelProperty("父部门ID")
    private Long parentId;

    /**
     * 祖级列表
     */
    @ApiModelProperty("祖级列表")
    private String ancestors;

    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String deptName;

    /**
     * 单位类型
     */
    @ApiModelProperty("单位类型")
    @Dict(dictValue = "dept_type")
    private String deptType;
    private String deptTypeDictLabel;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private String orderNum;

    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private String leader;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
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
    @ApiModelProperty("详细地址")
    private String detailedAddress;

    /**
     * 部门状态:0正常,1停用
     */
    @ApiModelProperty("部门状态:0正常,1停用")
    private String status;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty("统一社会信用代码")
    private String creditCode;

    /**
     * 法定代表人姓名
     */
    @ApiModelProperty("法定代表人姓名")
    private String legalName;

    /**
     * 法定代表人身份证号
     */
    @ApiModelProperty("法定代表人身份证号")
    @SensitiveInfo(SensitiveType.ID_CARD)
    private String legalCode;

    /**
     * 负责人姓名
     */
    @ApiModelProperty("负责人姓名")
    private String chargeName;

    /**
     * 负责人身份证号
     */
    @ApiModelProperty("负责人身份证号")
    @SensitiveInfo(SensitiveType.ID_CARD)
    private String chargeCode;

    /**
     * 经营许可证地址
     */
    @ApiModelProperty("经营许可证地址图片")
    private String licenseUrl;


    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 父单位名称
     */
    private String parentName;

    /**
     * 联系人姓名
     */
    @ApiModelProperty("联系人姓名")
    private String linkName;
    /**
     * 联系人电话
     */
    @SensitiveInfo(SensitiveType.MOBILE_PHONE)
    @ApiModelProperty("联系人电话")
    private String linkPhone;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private Integer level;

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    /**
     * 子部门
     */
    private List<SysDept> children = new ArrayList<SysDept>();

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    @NotBlank(message = "单位名称不能为空")
    @Size(min = 0, max = 30, message = "单位名称长度不能超过30个字符")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    @NotBlank(message = "显示顺序不能为空")
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Size(min = 0, max = 13, message = "联系电话长度不能超过11个字符")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDeptTypeDictLabel() {
        return deptTypeDictLabel;
    }

    public void setDeptTypeDictLabel(String deptTypeDictLabel) {
        this.deptTypeDictLabel = deptTypeDictLabel;
    }

    public String getDistrictCodeDictLabel() {
        return districtCodeDictLabel;
    }

    public void setDistrictCodeDictLabel(String districtCodeDictLabel) {
        this.districtCodeDictLabel = districtCodeDictLabel;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysDept> getChildren() {
        return children;
    }

    public void setChildren(List<SysDept> children) {
        this.children = children;
    }


    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalCode() {
        return legalCode;
    }

    public void setLegalCode(String legalCode) {
        this.legalCode = legalCode;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deptId", getDeptId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("deptName", getDeptName())
                .append("orderNum", getOrderNum())
                .append("leader", getLeader())
                .append("phone", getPhone())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
