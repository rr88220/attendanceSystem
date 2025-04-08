package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.StudentZenClassEntity;
import com.example.attendanceSystem.persistence.StudentZenClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentZenClassService {

    @Autowired
    private StudentZenClassRepository studentZenClassRepository;

    public StudentZenClassEntity update(StudentZenClassEntity studentZenClassEntity) {
        if(studentZenClassRepository.existsById(studentZenClassEntity.getId())) {
            return studentZenClassRepository.save(studentZenClassEntity);
        }
        return null;
    }

    public boolean delete(StudentZenClassEntity studentZenClassEntity) {
        if(studentZenClassRepository.existsById(studentZenClassEntity.getId())) {
            studentZenClassRepository.deleteById(studentZenClassEntity.getId());
            return true;
        }
        return false;
    }
}
