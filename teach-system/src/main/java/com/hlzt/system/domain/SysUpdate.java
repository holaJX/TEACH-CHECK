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
 * 应用更新对象 sys_update
 *
 * @author slx
 * @date 2021-06-01
 */
@Data
@ApiModel("应用更新")
public class SysUpdate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "${comment}")
    private Long updateId;

    /**
     * 版本号
     */
    @Excel(name = "版本号")
    @ApiModelProperty(value = "版本号")
    private String version;

    /**
     * 更新内容
     */
    @Excel(name = "更新内容")
    @ApiModelProperty(value = "更新内容")
    private String content;

    /**
     * 应用地址
     */
    @ApiModelProperty(value = "更新内容")
    private String appUrl;

    /**
     * 是否最新
     */
    @Excel(name = "是否最新")
    @Dict(dictValue = "sys_yes_no")
    @ApiModelProperty(value = "是否最新")
    private String isLast;
    private String isLastDictLabel;

    /**
     * 应用二维码
     */
    @Excel(name = "应用二维码")
    @ApiModelProperty(value = "应用二维码")
    private String qrcodeUrl;

    /**
     * $column.columnComment
     */
    private Integer delFlag;

    /**
     * $column.columnComment
     */
    private Long state;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("updateId", getUpdateId())
                .append("version", getVersion())
                .append("content", getContent())
                .append("appUrl", getAppUrl())
                .append("isLast", getIsLast())
                .append("qrcodeUrl", getQrcodeUrl())
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
