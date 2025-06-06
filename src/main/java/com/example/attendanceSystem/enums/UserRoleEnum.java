package com.example.attendanceSystem.enums;

public enum UserRoleEnum {

    ADMIN("管理員"),

    MEMBER("使用者");

    private String chName;

    private UserRoleEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
