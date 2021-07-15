package com.hlzt.common.enums;

/**
 * 消息类型
 * @author hlzt-slx
 */

public enum NotificationType {
    TASK_ARRANGEMENT("自动提醒","1"),
    NOTICE_ARRANGEMENT("上级通知","2");
    /**
     * 名称
     */
    private String name;
    /**
     * 值
     */
    private String value;


    private NotificationType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
