package com.example.attendanceSystem.enums;

public enum AttendanceStatusEnum {

    PRESENT("出席"),

    LATE("遲到"),

    SICK_LEAVE("病假"),

    PERSONAL_LEAVE("事假"),

    OFFICIAL_LEAVE("公假"),

    NONE("無故未出席");

    private String chName;

    private AttendanceStatusEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
