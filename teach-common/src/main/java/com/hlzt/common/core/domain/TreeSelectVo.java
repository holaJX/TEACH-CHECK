package com.hlzt.common.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.core.domain.entity.SysMenu;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 *
 * @author ruo-yi
 */
@ApiModel("树结构实体类")
public class TreeSelectVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    private Long id;

    /**
     * 节点名称
     */
    private String label;

    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    private Integer level;

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    private Boolean isDisabled;

    /**
     * 子节点
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelectVo> children;

    public TreeSelectVo() {

    }

    public TreeSelectVo(SysDept dept) {
        this.id = dept.getDeptId();
        this.label = dept.getDeptName();
        this.level=dept.getLevel();
        if (dept.getLevel() == 0) {
            if (dept.getChildren() == null || dept.getChildren().size() == 0) {
                this.isDisabled = true;

            }
        }
        this.children = dept.getChildren().stream().map(TreeSelectVo::new).collect(Collectors.toList());
    }

    public TreeSelectVo(SysMenu menu) {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(TreeSelectVo::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeSelectVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeSelectVo> children) {
        this.children = children;
    }
}
