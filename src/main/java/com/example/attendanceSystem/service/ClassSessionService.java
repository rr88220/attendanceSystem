package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ClassSessionEntity;
import com.example.attendanceSystem.persistence.ClassSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSessionService {

    @Autowired
    private ClassSessionRepository classSessionRepository;

    public ClassSessionEntity update(ClassSessionEntity classSessionEntity) {
        if(classSessionRepository.existsById(classSessionEntity.getId())) {
            return classSessionRepository.save(classSessionEntity);
        }
        return null;
    }

    public boolean delete(ClassSessionEntity classSessionEntity) {
        if(classSessionRepository.existsById(classSessionEntity.getId())) {
            classSessionRepository.deleteById(classSessionEntity.getId());
            return true;
        }
        return false;
    }
}
