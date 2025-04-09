package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.StudentRepository;
import com.example.attendanceSystem.persistence.StudentZenClassEntity;
import com.example.attendanceSystem.persistence.StudentZenClassRepository;
import com.example.attendanceSystem.persistence.ZenClassRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentZenClassService {

    @Autowired
    private StudentZenClassRepository studentZenClassRepository;

    @Autowired
    private ZenClassRepository zenClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentZenClassEntity save(StudentZenClassEntity studentZenClassEntity) {
        if (this.checkEntity(studentZenClassEntity)) {
            return studentZenClassRepository.save(studentZenClassEntity);
        }
        return null;
    }

    public List<StudentZenClassEntity> findAll() {
        return studentZenClassRepository.findAll();
    }

    public StudentZenClassEntity update(StudentZenClassEntity studentZenClassEntity) {
        if(studentZenClassRepository.existsById(studentZenClassEntity.getId())) {
            return studentZenClassRepository.save(studentZenClassEntity);
        }
        return null;
    }

    public boolean delete(long studentZenClassId) {
        if(studentZenClassRepository.existsById(studentZenClassId)) {
            studentZenClassRepository.deleteById(studentZenClassId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(StudentZenClassEntity studentZenClassEntity) {
        if (studentZenClassEntity.getZenClassId() == null ||
                !zenClassRepository.existsById(studentZenClassEntity.getZenClassId())) {
            return false;
        }
        return studentZenClassEntity.getStudentId() != null &&
                studentRepository.existsById(studentZenClassEntity.getStudentId());
    }
}
