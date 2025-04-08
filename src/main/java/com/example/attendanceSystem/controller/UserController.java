package com.example.attendanceSystem.controller;

import com.example.attendanceSystem.persistence.UserEntity;
import com.example.attendanceSystem.persistence.UserRepository;
import com.example.attendanceSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserEntity> Login(@RequestBody UserEntity userEntity) {
        UserEntity user = userRepository.findByNameAndPassword(userEntity.getName(), userEntity.getPassword());
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> Create(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.save(userEntity);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/update")
    public ResponseEntity<UserEntity> Update(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.update(userEntity);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> Delete(@RequestBody UserEntity userEntity) {
        if(userService.delete(userEntity)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
