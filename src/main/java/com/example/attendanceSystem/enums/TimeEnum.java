package com.example.attendanceSystem.enums;

public enum TimeEnum {

    DAY("日間"),

    NIGHT("夜間");

    private String chName;

    private TimeEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
