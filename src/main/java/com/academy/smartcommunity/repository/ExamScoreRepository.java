// src/main/java/com/academy/smartcommunity/repository/ExamScoreRepository.java
package com.academy.smartcommunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.smartcommunity.model.ExamScore;

public interface ExamScoreRepository extends JpaRepository<ExamScore, Long> {
    List<ExamScore> findByStudentId(Long studentId);
}
