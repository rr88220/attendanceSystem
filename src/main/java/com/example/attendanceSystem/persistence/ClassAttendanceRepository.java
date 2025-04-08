package com.example.attendanceSystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassAttendanceRepository extends JpaRepository<ClassAttendanceEntity, Long> {
}
