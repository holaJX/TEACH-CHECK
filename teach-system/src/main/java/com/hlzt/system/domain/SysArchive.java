package com.hlzt.system.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 文档管理对象 sys_archive
 * 
 * @author dengyy
 * @date 2021-06-06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ApiModel("文档管理")
public class SysArchive extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty(value = "ID")
    private Long archiveId;

    /** 文档名称 */
    @Excel(name = "文档名称")
    @ApiModelProperty(value = "文档名称")
    private String name;

    /** 文档类型 */
    @Excel(name = "文档类型")
    @Dict(dictValue = "arch_type")
    @ApiModelProperty(value = "文档类型")
    private String type;
    private String typeDictLabel;

    /** 文档大小 */
    @Excel(name = "文档大小")
    @ApiModelProperty(value = "文档大小")
    private BigDecimal size;

    /** 文档地址 */
    @Excel(name = "文档地址")
    @ApiModelProperty(value = "文档地址")
    private String url;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("archiveId", getArchiveId())
            .append("name", getName())
            .append("type", getType())
            .append("size", getSize())
            .append("url", getUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
