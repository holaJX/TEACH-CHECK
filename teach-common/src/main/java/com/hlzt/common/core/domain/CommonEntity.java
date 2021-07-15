package com.hlzt.common.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 公共Dto类
 * 
 * @author ruo-yi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonEntity extends BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long deptId;

    private String type;

    private String avatar;

    private String name;

    private String label;

    private String value;

    private String state;

    private String checkType;

    private Long userId;

    private Long teamId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<?> children = new ArrayList<>();
}
