package com.hlzt.common.core.domain;

import com.hlzt.common.utils.StringUtils;

import java.util.*;

/**
 * 下拉树
 */
public class ElTree {
    private Integer id;
    private Integer parentId;
    private String value;
    private String label;
    private List<ElTree> children;


    public List<ElTree> listTransElTree(List<Map<String,Object>> listMap) {
        List<ElTree> elTrees = new ArrayList<ElTree>();
        for (Map<String, Object> map : listMap) {
            elTrees.add(
                    new ElTree(
                            (Integer) map.get("id"),
                            (Integer) map.get("parentId"),
                            String.valueOf(map.get("value")),
                            String.valueOf(map.get("label"))
                    )
            );
        }
        return findChildren(elTrees,0);
    }
    public List<ElTree> findChildren(List<ElTree> list,Integer pid) {
        List<ElTree> elTrees = new ArrayList<>();
        Iterator<ElTree> it = list.iterator();
        while (it.hasNext()) {
            ElTree elTree = it.next();
            if (elTree.parentId == pid) {
                elTrees.add(elTree);
                it.remove();
            }
        }
        elTrees.forEach(n -> n.children = findChildren(list,n.id));
        return elTrees;
    }





    public ElTree() {
    }

    public ElTree(Integer id, Integer parentId, String value, String label) {
        this.id = id;
        this.parentId = parentId;
        this.value = value;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ElTree> getChildren() {
        return children;
    }

    public void setChildren(List<ElTree> children) {
        this.children = children;
    }
}