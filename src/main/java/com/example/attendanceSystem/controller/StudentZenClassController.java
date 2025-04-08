package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.StudentEntity;
import com.example.attendanceSystem.persistence.StudentZenClassEntity;
import com.example.attendanceSystem.persistence.StudentZenClassRepository;
import com.example.attendanceSystem.service.StudentZenClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentZenClass")
public class StudentZenClassController {

    @Autowired
    private StudentZenClassRepository studentZenClassRepository;

    @Autowired
    private StudentZenClassService studentZenClassService;

    @PostMapping("/create")
    public ResponseEntity<StudentZenClassEntity> Create(@RequestBody StudentZenClassEntity studentZenClassEntity) {
        StudentZenClassEntity studentZenClass = studentZenClassRepository.save(studentZenClassEntity);
        return ResponseEntity.ok(studentZenClass);
    }

    @PostMapping("/query")
    public ResponseEntity<List<StudentZenClassEntity>> Query() {
        List<StudentZenClassEntity> studentZenClassList = studentZenClassRepository.findAll();
        return ResponseEntity.ok(studentZenClassList);
    }

    @PostMapping("/update")
    public ResponseEntity<StudentZenClassEntity> Update(@RequestBody StudentZenClassEntity studentZenClassEntity) {
        StudentZenClassEntity studentZenClass = studentZenClassService.update(studentZenClassEntity);
        if(studentZenClass != null) return ResponseEntity.ok(studentZenClass);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody StudentZenClassEntity studentZenClassEntity) {
        if(studentZenClassService.delete(studentZenClassEntity)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
