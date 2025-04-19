// src/main/java/com/academy/smartcommunity/repository/WeaknessRepository.java
package com.academy.smartcommunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.smartcommunity.model.Weakness;

public interface WeaknessRepository extends JpaRepository<Weakness, Long> {
    List<Weakness> findByStudentId(Long studentId);
}
