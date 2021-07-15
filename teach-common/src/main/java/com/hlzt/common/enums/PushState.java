package com.hlzt.common.enums;

public enum PushState {
    PUSHED("已推送","1"),
    NOPUSH("未推送","2"),
    FAILED("推送失败","3"),
    SUCCESS("推送成功","4");
    private String name;
    private String value;


    private PushState(String name,String value) {
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
