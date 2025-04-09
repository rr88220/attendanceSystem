package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.ZenClassEntity;
import com.example.attendanceSystem.persistence.ZenClassRepository;
import com.example.attendanceSystem.service.ZenClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zenClass")
public class ZenClassController {

    @Autowired
    private ZenClassService zenClassService;

    @PostMapping("/create")
    public ResponseEntity<ZenClassEntity> Create(@RequestBody ZenClassEntity zenClassEntity) {
        ZenClassEntity zenClass = zenClassService.save(zenClassEntity);
        if (zenClass != null) return ResponseEntity.ok(zenClass);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/query")
    public ResponseEntity<List<ZenClassEntity>> Query() {
        List<ZenClassEntity> zenClassList = zenClassService.findAll();
        return ResponseEntity.ok(zenClassList);
    }

    @PostMapping("/update")
    public ResponseEntity<ZenClassEntity> Update(@RequestBody ZenClassEntity zenClassEntity) {
        ZenClassEntity zenClass = zenClassService.update(zenClassEntity);
        if(zenClass != null) return ResponseEntity.ok(zenClass);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody long zenClassId) {
        if(zenClassService.delete(zenClassId)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
