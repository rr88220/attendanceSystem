package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.ClassSessionEntity;
import com.example.attendanceSystem.persistence.ClassSessionRepository;
import com.example.attendanceSystem.service.ClassSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classSession")
public class ClassSessionController {

    @Autowired
    private ClassSessionRepository classSessionRepository;

    @Autowired
    private ClassSessionService classSessionService;

    @PostMapping("/create")
    public ResponseEntity<ClassSessionEntity> Create(@RequestBody ClassSessionEntity classSessionEntity) {
        ClassSessionEntity classSession = classSessionRepository.save(classSessionEntity);
        return ResponseEntity.ok(classSession);
    }

    @PostMapping("/query")
    public ResponseEntity<List<ClassSessionEntity>> Query() {
        List<ClassSessionEntity> classSessionList = classSessionRepository.findAll();
        return ResponseEntity.ok(classSessionList);
    }

    @PostMapping("/update")
    public ResponseEntity<ClassSessionEntity> Update(@RequestBody ClassSessionEntity classSessionEntity) {
        ClassSessionEntity classSession = classSessionService.update(classSessionEntity);
        if(classSession != null) return ResponseEntity.ok(classSession);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody ClassSessionEntity classSessionEntity) {
        if(classSessionService.delete(classSessionEntity)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
