package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ZenClassEntity;
import com.example.attendanceSystem.persistence.ZenClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZenClassService {

    @Autowired
    private ZenClassRepository zenClassRepository;

    public ZenClassEntity update(ZenClassEntity zenClassEntity) {
        if(zenClassRepository.existsById(zenClassEntity.getId())) {
            return zenClassRepository.save(zenClassEntity);
        }
        return null;
    }

    public boolean delete(ZenClassEntity zenClassEntity) {
        if(zenClassRepository.existsById(zenClassEntity.getId())) {
            zenClassRepository.deleteById(zenClassEntity.getId());
            return true;
        }
        return false;
    }
}
