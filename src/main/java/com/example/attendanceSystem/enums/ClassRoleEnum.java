package com.example.attendanceSystem.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClassRoleEnum {

    @JsonProperty("0")
    CHIEF_SENIOR("總學長"),

    @JsonProperty("1")
    DEPUTY_CHIEF_SENIOR("副總學長"),

    @JsonProperty("2")
    SENIOR("學長"),

    @JsonProperty("3")
    ASSISTANT_SENIOR("副學長"),

    @JsonProperty("4")
    SECRETARY("幹事"),

    @JsonProperty("5")
    MEMBER("學員");

    private String chName;

    private ClassRoleEnum(String chName) {
        this.chName =  chName;
    }

    public String getChName() {
        return chName;
    }
}
