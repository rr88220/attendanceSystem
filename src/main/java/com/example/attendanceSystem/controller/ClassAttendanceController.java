package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.ClassAttendanceEntity;
import com.example.attendanceSystem.persistence.ClassAttendanceRepository;
import com.example.attendanceSystem.service.ClassAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classAttendance")
public class ClassAttendanceController {

    @Autowired
    private ClassAttendanceService classAttendanceService;

    @PostMapping("/create")
    public ResponseEntity<ClassAttendanceEntity> Create(@RequestBody ClassAttendanceEntity classAttendanceEntity) {
        ClassAttendanceEntity classAttendance = classAttendanceService.save(classAttendanceEntity);
        if(classAttendance != null) return ResponseEntity.ok(classAttendance);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/query")
    public ResponseEntity<List<ClassAttendanceEntity>> Query() {
        List<ClassAttendanceEntity> classAttendanceList = classAttendanceService.findAll();
        return ResponseEntity.ok(classAttendanceList);
    }

    @PostMapping("/update")
    public ResponseEntity<ClassAttendanceEntity> Update(@RequestBody ClassAttendanceEntity classAttendanceEntity) {
        ClassAttendanceEntity classAttendance = classAttendanceService.update(classAttendanceEntity);
        if(classAttendance != null) return ResponseEntity.ok(classAttendance);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody long classAttendanceId) {
        if(classAttendanceService.delete(classAttendanceId)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
