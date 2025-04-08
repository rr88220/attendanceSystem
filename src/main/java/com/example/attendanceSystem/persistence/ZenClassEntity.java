package com.example.attendanceSystem.persistence;

import com.example.attendanceSystem.enums.ClassLevelEnum;

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
    @Enumerated(EnumType.ORDINAL)
    private ClassLevelEnum level;

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
}
