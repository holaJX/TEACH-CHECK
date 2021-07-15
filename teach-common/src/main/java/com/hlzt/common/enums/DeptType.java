package com.hlzt.common.enums;

/**
 * 用户部门大类枚举
 *
 * @author slx
 */
public enum DeptType {
    CONSTRUCTION(100L, "建设单位"),
    SUPERVISION(200L, "监管单位"),
    SERVICE(300L, "服务机构"),
    INDUSTRY(400L, "行业单位");

    private final Long deptId;
    private final String info;

    DeptType(Long deptId, String info) {
        this.deptId = deptId;
        this.info = info;
    }

    public Long getDeptId() {
        return deptId;
    }

    public String getInfo() {
        return info;
    }
}
