package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.StudentEntity;
import com.example.attendanceSystem.persistence.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity save(StudentEntity studentEntity) {
        if (this.checkEntity(studentEntity)) {
            return studentRepository.save(studentEntity);
        }
        return null;
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity update(StudentEntity studentEntity) {
        if(studentRepository.existsById(studentEntity.getId())) {
            return studentRepository.save(studentEntity);
        }
        return null;
    }

    public boolean delete(long studentId) {
        if(studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(StudentEntity studentEntity) {
        if (StringUtils.isBlank(studentEntity.getName())) {
            return false;
        }
        if (StringUtils.isBlank(studentEntity.getPhone())) {
            return false;
        }
        if (StringUtils.isBlank(studentEntity.getEmergencyContact())) {
            return false;
        }
        if (StringUtils.isBlank(studentEntity.getEmergencyContactRelation())) {
            return false;
        }
        return !StringUtils.isBlank(studentEntity.getEmergencyContactPhone());
    }
}
