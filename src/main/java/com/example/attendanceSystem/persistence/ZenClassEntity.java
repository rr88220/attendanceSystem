package com.example.attendanceSystem.persistence;

import com.example.attendanceSystem.enums.ClassLevelEnum;
import com.example.attendanceSystem.enums.TimeEnum;
import com.example.attendanceSystem.enums.WeekEnum;

import javax.persistence.*;

@Entity
@Table(name = "zen_class")
public class ZenClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "period")
    private String period;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private ClassLevelEnum level;

    @Column(name = "week")
    @Enumerated(EnumType.STRING)
    private WeekEnum week;

    @Column(name = "time")
    @Enumerated(EnumType.STRING)
    private TimeEnum time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public ClassLevelEnum getLevel() {
        return level;
    }

    public void setLevel(ClassLevelEnum level) {
        this.level = level;
    }

    public WeekEnum getWeek() {
        return week;
    }

    public void setWeek(WeekEnum week) {
        this.week = week;
    }

    public TimeEnum getTime() {
        return time;
    }

    public void setTime(TimeEnum time) {
        this.time = time;
    }
}
