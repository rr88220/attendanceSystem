package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.UserEntity;
import com.example.attendanceSystem.persistence.UserRepository;
import com.example.attendanceSystem.service.UserService;
import com.example.attendanceSystem.valueObject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> Create(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.save(userEntity);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> Login(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.login(userEntity);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/query")
    public ResponseEntity<Page<UserEntity>> Query(
            @RequestBody User userParam,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<UserEntity> userList = userService.findAll(userParam, page, size);
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/update")
    public ResponseEntity<UserEntity> Update(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.update(userEntity);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody long userId) {
        if(userService.delete(userId)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
