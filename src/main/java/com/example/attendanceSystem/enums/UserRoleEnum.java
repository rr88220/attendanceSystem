package com.example.attendanceSystem.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRoleEnum {

    @JsonProperty("0")
    ADMIN("管理員"),

    @JsonProperty("1")
    MEMBER("使用者");

    private String chName;

    private UserRoleEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
