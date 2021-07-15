package com.hlzt.common.enums;

public enum ReceiverState {
    RECEIVERED("已接收","1"),
    NORECEIVER("未接收","2");
    private String name;
    private String value;


    private ReceiverState(String name, String value) {
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
