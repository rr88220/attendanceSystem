package com.example.attendanceSystem.service;

import com.example.attendanceSystem.persistence.ZenClassEntity;
import com.example.attendanceSystem.persistence.ZenClassRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZenClassService {

    @Autowired
    private ZenClassRepository zenClassRepository;

    public ZenClassEntity save(ZenClassEntity zenClassEntity) {
        if (this.checkEntity(zenClassEntity)) {
            return zenClassRepository.save(zenClassEntity);
        }
        return null;
    }

    public List<ZenClassEntity> findAll() {
        return zenClassRepository.findAll();
    }

    public ZenClassEntity update(ZenClassEntity zenClassEntity) {
        if(zenClassRepository.existsById(zenClassEntity.getId())) {
            return zenClassRepository.save(zenClassEntity);
        }
        return null;
    }

    public boolean delete(long zenClassId) {
        if(zenClassRepository.existsById(zenClassId)) {
            zenClassRepository.deleteById(zenClassId);
            return true;
        }
        return false;
    }

    private boolean checkEntity(ZenClassEntity zenClassEntity) {
        return !StringUtils.isBlank(zenClassEntity.getPeriod());
    }
}
