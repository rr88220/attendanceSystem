package com.example.attendanceSystem.enums;

public enum StatusEnum {

    ENABLE("啟用"),

    CLOSE("停用");

    private String chName;

    private StatusEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
