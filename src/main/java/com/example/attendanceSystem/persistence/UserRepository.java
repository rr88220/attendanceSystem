package com.example.attendanceSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByNameAndPassword(String name, String password);
}
