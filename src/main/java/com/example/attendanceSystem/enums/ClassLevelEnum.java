package com.example.attendanceSystem.enums;

public enum ClassLevelEnum {

    BEGINNER("初級班"),

    INTERMEDIATE("中級班"),

    ADVANCED("高級班"),

    SUTRA_STUDY("研經班"),

    MAHAYANA("大乘班");

    private String chName;

    private ClassLevelEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
