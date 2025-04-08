package com.example.attendanceSystem.persistence;

import com.example.attendanceSystem.enums.ClassRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "student_zen_class")
public class StudentZenClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "zen_class_id")
    private Long zenClassId;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private ClassRoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getZenClassId() {
        return zenClassId;
    }

    public void setZenClassId(Long zenClassId) {
        this.zenClassId = zenClassId;
    }

    public ClassRoleEnum getRole() {
        return role;
    }

    public void setRole(ClassRoleEnum role) {
        this.role = role;
    }
}
