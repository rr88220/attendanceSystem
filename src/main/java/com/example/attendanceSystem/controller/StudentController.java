package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.StudentEntity;
import com.example.attendanceSystem.persistence.StudentRepository;
import com.example.attendanceSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentEntity> Create(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentRepository.save(studentEntity);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/query")
    public ResponseEntity<List<StudentEntity>> Query() {
        List<StudentEntity> studentList = studentRepository.findAll();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/update")
    public ResponseEntity<StudentEntity> Update(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentService.update(studentEntity);
        if(student != null) return ResponseEntity.ok(student);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody StudentEntity studentEntity) {
        if(studentService.delete(studentEntity)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
