package com.hlzt.common.enums;

/**
 * 用户角色大类枚举
 *
 * @author slx
 */
public enum RoleType {

    CONSTRUCTION(101L,"construction", "竣工查验人员"),
    TEACH(102L, "teach","消防示教点评人员"),
    SERVICE(103L, "service","消防检测人员"),
    CONSTRUCTION_ADMIN(110L, "construction-admin","建设单位管理人员"),
    TEACH_ADMIN(120L, "teach-admin","消防示教单位管理人员"),
    SERVICE_ADMIN(130L, "service-admin","服务机构管理人员");

    private final Long roleId;
    private final String roleName;
    private final String roleKey;

    RoleType(Long roleId, String roleKey, String roleName) {
        this.roleId = roleId;
        this.roleKey = roleKey;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }
}
