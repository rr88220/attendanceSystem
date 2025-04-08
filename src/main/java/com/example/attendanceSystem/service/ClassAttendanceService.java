package com.example.attendanceSystem.service;

import com.example.attendanceSystem.enums.AttendanceStatusEnum;
import com.example.attendanceSystem.persistence.ClassAttendanceEntity;
import com.example.attendanceSystem.persistence.ClassAttendanceRepository;
import com.example.attendanceSystem.persistence.ClassSessionRepository;
import com.example.attendanceSystem.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassAttendanceService {

    @Autowired
    private ClassAttendanceRepository classAttendanceRepository;

    @Autowired
    private ClassSessionRepository classSessionRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ClassAttendanceEntity save(ClassAttendanceEntity classAttendanceEntity) {
        if (this.checkEntity(classAttendanceEntity)) {
            return classAttendanceRepository.save(classAttendanceEntity);
        }
        return null;
    }

    public ClassAttendanceEntity update(ClassAttendanceEntity classAttendanceEntity) {
        if(classAttendanceRepository.existsById(classAttendanceEntity.getId())) {
            return classAttendanceRepository.save(classAttendanceEntity);
        }
        return null;
    }

    public boolean delete(ClassAttendanceEntity classAttendanceEntity) {
        if(classAttendanceRepository.existsById(classAttendanceEntity.getId())) {
            classAttendanceRepository.deleteById(classAttendanceEntity.getId());
            return true;
        }
        return false;
    }

    private boolean checkEntity(ClassAttendanceEntity classAttendanceEntity) {
        boolean check = true;
        if (classAttendanceEntity.getClassSessionId() == null ||
                !classSessionRepository.existsById(classAttendanceEntity.getClassSessionId())) {
            check = false;
        }
        if (classAttendanceEntity.getStudentId() == null ||
                !studentRepository.existsById(classAttendanceEntity.getStudentId())) {
            check = false;
        }
        return check;
    }
}
