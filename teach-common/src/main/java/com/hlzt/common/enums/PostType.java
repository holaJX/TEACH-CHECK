package com.hlzt.common.enums;

/**
 * 用户部门大类枚举
 *
 * @author slx
 */
public enum PostType {

    CEO(1L, "法定代表人","ceo"),
    PM(2L, "项目负责人","pm"),
    USER(3L,"验收人员", "user"),
    CTO(4L, "技术负责人","cto"),
    SYS(5L, "系统管理员","sys");

    private final Long postId;
    private final String postName;
    private final String postKey;

    PostType(Long postId, String postName, String postKey) {
        this.postId = postId;
        this.postName = postName;
        this.postKey = postKey;
    }

    public Long getPostId() {
        return postId;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostKey() {
        return postKey;
    }
}
