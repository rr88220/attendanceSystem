package com.example.attendanceSystem.enums;

public enum ClassRoleEnum {

    CHIEF_SENIOR("總學長"),

    DEPUTY_CHIEF_SENIOR("副總學長"),

    SENIOR("學長"),

    ASSISTANT_SENIOR("副學長"),

    SECRETARY("幹事"),

    MEMBER("學員");

    private String chName;

    private ClassRoleEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
