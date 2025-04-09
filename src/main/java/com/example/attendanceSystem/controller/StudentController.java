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
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentEntity> Create(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentService.save(studentEntity);
        if (student != null) return ResponseEntity.ok(student);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/query")
    public ResponseEntity<List<StudentEntity>> Query() {
        List<StudentEntity> studentList = studentService.findAll();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/update")
    public ResponseEntity<StudentEntity> Update(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentService.update(studentEntity);
        if(student != null) return ResponseEntity.ok(student);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody long studentId) {
        if(studentService.delete(studentId)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
