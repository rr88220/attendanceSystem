package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.UserEntity;
import com.example.attendanceSystem.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity update(UserEntity userEntity) {
        if(userRepository.existsById(userEntity.getId())) {
            return userRepository.save(userEntity);
        }
        return null;
    }

    public boolean delete(UserEntity userEntity) {
        if(userRepository.existsById(userEntity.getId())) {
            userRepository.deleteById(userEntity.getId());
            return true;
        }
        return false;
    }
}
