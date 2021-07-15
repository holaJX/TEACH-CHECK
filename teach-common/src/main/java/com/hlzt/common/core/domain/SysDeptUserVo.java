package com.hlzt.common.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门表 sys_dept
 *
 * @author ruo-yi
 */
@Data
@ApiModel("部门人员表")
public class SysDeptUserVo {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 父ID
     */
    @ApiModelProperty("父ID")
    private Long parentId;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SysDeptUserVo> children = new ArrayList<>();

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String level;


    @ApiModelProperty("是否点击")
    private String isDisabled;

    /**
     * 单位名称
     */
    @ApiModelProperty("名称")
    private String label;
}
