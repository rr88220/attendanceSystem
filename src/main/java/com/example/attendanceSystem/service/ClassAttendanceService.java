package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ClassAttendanceEntity;
import com.example.attendanceSystem.persistence.ClassAttendanceRepository;
import com.example.attendanceSystem.persistence.ClassSessionRepository;
import com.example.attendanceSystem.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ClassAttendanceEntity> findAll() {
        return classAttendanceRepository.findAll();
    }

    public ClassAttendanceEntity update(ClassAttendanceEntity classAttendanceEntity) {
        if(classAttendanceRepository.existsById(classAttendanceEntity.getId())) {
            return classAttendanceRepository.save(classAttendanceEntity);
        }
        return null;
    }

    public boolean delete(long classAttendanceId) {
        if(classAttendanceRepository.existsById(classAttendanceId)) {
            classAttendanceRepository.deleteById(classAttendanceId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(ClassAttendanceEntity classAttendanceEntity) {
        if (classAttendanceEntity.getClassSessionId() == null ||
                !classSessionRepository.existsById(classAttendanceEntity.getClassSessionId())) {
            return false;
        }
        return classAttendanceEntity.getStudentId() != null &&
                studentRepository.existsById(classAttendanceEntity.getStudentId());
    }
}
