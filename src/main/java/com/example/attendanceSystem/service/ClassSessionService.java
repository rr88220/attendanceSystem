package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ClassSessionEntity;
import com.example.attendanceSystem.persistence.ClassSessionRepository;
import com.example.attendanceSystem.persistence.ZenClassRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSessionService {

    @Autowired
    private ClassSessionRepository classSessionRepository;

    @Autowired
    private ZenClassRepository zenClassRepository;

    public ClassSessionEntity save(ClassSessionEntity classSessionEntity) {
        if (this.checkEntity(classSessionEntity)) {
            return classSessionRepository.save(classSessionEntity);
        }
        return null;
    }

    public List<ClassSessionEntity> findAll() {
        return classSessionRepository.findAll();
    }

    public ClassSessionEntity update(ClassSessionEntity classSessionEntity) {
        if(classSessionRepository.existsById(classSessionEntity.getId())) {
            return classSessionRepository.save(classSessionEntity);
        }
        return null;
    }

    public boolean delete(long classSessionId) {
        if(classSessionRepository.existsById(classSessionId)) {
            classSessionRepository.deleteById(classSessionId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(ClassSessionEntity classSessionEntity) {
        if (classSessionEntity.getZenClassId() == null ||
                !zenClassRepository.existsById(classSessionEntity.getZenClassId())) {
            return false;
        }
        if (StringUtils.isBlank(classSessionEntity.getTopic())) {
            return false;
        }
        return classSessionEntity.getSessionDate() != null;
    }
}
