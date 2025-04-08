package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.StudentEntity;
import com.example.attendanceSystem.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity update(StudentEntity studentEntity) {
        if(studentRepository.existsById(studentEntity.getId())) {
            return studentRepository.save(studentEntity);
        }
        return null;
    }

    public boolean delete(StudentEntity studentEntity) {
        if(studentRepository.existsById(studentEntity.getId())) {
            studentRepository.deleteById(studentEntity.getId());
            return true;
        }
        return false;
    }
}
