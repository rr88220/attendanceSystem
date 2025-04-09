package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.UserEntity;
import com.example.attendanceSystem.persistence.UserRepository;
import com.example.attendanceSystem.valueObject.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

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

    public UserEntity login(UserEntity userEntity) {
        return userRepository.findByNameAndPassword(userEntity.getName(), userEntity.getPassword());
    }

    public Page<UserEntity> findAll(User userParam, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<UserEntity> specification = (root, query, cb) -> {
            List<Predicate> params = new ArrayList<>();
            if (!StringUtils.isBlank(userParam.getName())) {
                params.add(cb.like(root.get("name"), "%" + userParam.getName() + "%"));
            }
            if (userParam.getRole() != null) {
                params.add(cb.equal(root.get("role"), userParam.getRole()));
            }
            if (userParam.getStatus() != null) {
                params.add(cb.equal(root.get("status"), userParam.getStatus()));
            }
            Predicate[] predicates = new Predicate[params.size()];
            return cb.and(params.toArray(predicates));
        };
        return userRepository.findAll(specification, pageable);
    }

    public UserEntity update(UserEntity userEntity) {
        if(userRepository.existsById(userEntity.getId())) {
            return userRepository.save(userEntity);
        }
        return null;
    }

    public boolean delete(long userId) {
        if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(UserEntity userEntity) {
        if (StringUtils.isBlank(userEntity.getName())) {
            return false;
        }
        return !StringUtils.isBlank(userEntity.getPassword());
    }
}
