package com.example.attendanceSystem.persistence;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "class_session")
public class ClassSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zen_class_id")
    private Long zenClassId;

    @Column(name = "session_date")
    private Date sessionDate;

    @Column(name = "topic")
    private String topic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZenClassId() {
        return zenClassId;
    }

    public void setZenClassId(Long zenClassId) {
        this.zenClassId = zenClassId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
