package com.example.attendanceSystem.enums;

public enum WeekEnum {
    Monday("星期一"),
    Tuesday("星期二"),
    Wednesday("星期三"),
    Thursday("星期四"),
    Friday("星期五"),
    Saturday("星期六"),
    Sunday("星期日");

    private String chName;

    private WeekEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
