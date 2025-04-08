package com.example.attendanceSystem.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AttendanceStatusEnum {

    @JsonProperty("0")
    PRESENT("出席"),

    @JsonProperty("1")
    LATE("遲到"),

    @JsonProperty("2")
    SICK_LEAVE("病假"),

    @JsonProperty("3")
    PERSONAL_LEAVE("事假"),

    @JsonProperty("4")
    OFFICIAL_LEAVE("公假"),

    @JsonProperty("5")
    NONE("無故未出席");

    private String chName;

    private AttendanceStatusEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
