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
 * 问题反馈对象 sys_question
 *
 * @author slx
 * @date 2021-06-01
 */
@Data
@ApiModel("问题反馈")
public class SysQuestion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    @Dict(dictValue = "question_type")
    @ApiModelProperty(value = "问题类型")
    private String type;
    private String typeDictLabel;

    /**
     * 问题说明
     */
    @Excel(name = "问题说明")
    @ApiModelProperty(value = "问题说明")
    private String content;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址(多张图片字符串拼接)")
    @ApiModelProperty(value = "图片地址")
    private String picUrl;

    /**
     * 公告状态（0正常 1关闭）
     */
    @Excel(name = "公告状态", readConverterExp = "0=正常,1=关闭")
    private String status;


    @ApiModelProperty(value = "电话号码")
    private String phonenumber;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("content", getContent())
                .append("picUrl", getPicUrl())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("status", getStatus())
                .toString();
    }
}
