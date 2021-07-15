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
public class TStandardVo {
    /**
     * 标准项standard_id, name, standard_reference, standard_type
     */
    @ApiModelProperty(value = "ID")
    private Long standardId;

    private  Long originstandardId;


    private  Long parentId;
    /**
     * 标准项目名称
     */
    private String name;
    private String checkCategory;
    /**   引用标准
     */

    @Excel(name = "标准项等级")
    @ApiModelProperty(value = "标准项等级")
    private Long level;
    /**
     * 现有标准
     */
    private  String standardReference;
    private  Boolean checked;

    private  String standardIdchecked;


    @Excel(name = "标准类型")
    @ApiModelProperty(value = "标准类型")
    private String standardType;

    /**
     * 原始标准id
     */
    private  String originStandardReference;
    /**
     * 原始标准名字
     */
    private  String originStandardReferenceName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TStandardVo> children = new ArrayList<>();

}
