package com.example.attendanceSystem.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClassLevelEnum {

    @JsonProperty("0")
    BEGINNER("初級班"),

    @JsonProperty("1")
    INTERMEDIATE("中級班"),

    @JsonProperty("2")
    ADVANCED("高級班"),

    @JsonProperty("3")
    SUTRA_STUDY("研經班"),

    @JsonProperty("4")
    MAHAYANA("大乘班");

    private String chName;

    private ClassLevelEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
