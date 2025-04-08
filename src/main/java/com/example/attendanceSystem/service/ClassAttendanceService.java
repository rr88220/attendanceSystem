package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ClassAttendanceEntity;
import com.example.attendanceSystem.persistence.ClassAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassAttendanceService {

    @Autowired
    private ClassAttendanceRepository classAttendanceRepository;

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
}
