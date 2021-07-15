package com.hlzt.system.domain;

import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 资格证信息对象 sys_certificate
 * 
 * @author dengyy
 * @date 2021-04-21
 */
public class SysCertificate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long certificateId;

    /** 用户Id */
    @Excel(name = "用户Id")
    private Long userId;

    /** 证件编号 */
    @Excel(name = "证件编号")
    private String certificateCode;

    /** 证件名称 */
    @Excel(name = "证件名称")
    private String certificateName;

    /** 证件类别 */
    @Excel(name = "证件类别")
    private String certificateType;

    /** 证件正面地址 */
    @Excel(name = "证件正面地址")
    private String certificateFrontUrl;
    /** 证件反面地址 */
    @Excel(name = "证件反面地址")
    private String certificateBackUrl;

    public void setCertificateId(Long certificateId) 
    {
        this.certificateId = certificateId;
    }

    public Long getCertificateId() 
    {
        return certificateId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCertificateCode(String certificateCode) 
    {
        this.certificateCode = certificateCode;
    }

    public String getCertificateCode() 
    {
        return certificateCode;
    }
    public void setCertificateName(String certificateName) 
    {
        this.certificateName = certificateName;
    }

    public String getCertificateName() 
    {
        return certificateName;
    }
    public void setCertificateType(String certificateType) 
    {
        this.certificateType = certificateType;
    }

    public String getCertificateType() 
    {
        return certificateType;
    }


    public String getCertificateFrontUrl() {
        return certificateFrontUrl;
    }

    public void setCertificateFrontUrl(String certificateFrontUrl) {
        this.certificateFrontUrl = certificateFrontUrl;
    }

    public String getCertificateBackUrl() {
        return certificateBackUrl;
    }

    public void setCertificateBackUrl(String certificateBackUrl) {
        this.certificateBackUrl = certificateBackUrl;
    }

    @Override
    public String toString() {
        return "SysCertificate{" +
                "certificateId=" + certificateId +
                ", userId=" + userId +
                ", certificateCode='" + certificateCode + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateFrontUrl='" + certificateFrontUrl + '\'' +
                ", certificateBackUrl='" + certificateBackUrl + '\'' +
                '}';
    }
}
