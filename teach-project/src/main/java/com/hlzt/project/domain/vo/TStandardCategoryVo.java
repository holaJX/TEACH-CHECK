package com.hlzt.project.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlzt.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 验收标准类型对象 acc_standard_category
 *
 * @author slx
 * @date 2021-04-27
 */
@Data
@ApiModel("验收标准类型")
public class TStandardCategoryVo {
    /**
     * 标准项id
     */
    @ApiModelProperty(value = "ID")
    private Long standardId;
    /**
     * 父菜单ID
     */
    private Long parentId;
    /**
     * 验收类型（竣工查验、消防检测、现场评定）
     */
    @Excel(name = "验收类型")
    @ApiModelProperty(value = "验收类型")
    private String type;

    /**
     * 比重
     */
    @Excel(name = "比重")
    @ApiModelProperty(value = "比重")
    private Double proportion;

    /**
     * 标准项名称
     */
    @Excel(name = "标准项名称")
    @ApiModelProperty(value = "标准项名称")
    private String name;
    private String checkCategory;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TStandardCategoryVo> children = new ArrayList<>();
    /**
     * 标准项等级
     */
    @Excel(name = "标准项等级")
    @ApiModelProperty(value = "标准项等级")
    private Long level;


}
