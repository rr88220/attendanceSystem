package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.UserEntity;
import com.example.attendanceSystem.persistence.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity save(UserEntity userEntity) {
        if (this.checkEntity(userEntity)) {
            return userRepository.save(userEntity);
        }
        return null;
    }

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

    private boolean checkEntity(UserEntity userEntity) {
        boolean check = true;
        if (StringUtils.isBlank(userEntity.getName())) {
            check = false;
        }
        if (StringUtils.isBlank(userEntity.getPassword())) {
            check = false;
        }
        return check;
    }
}
