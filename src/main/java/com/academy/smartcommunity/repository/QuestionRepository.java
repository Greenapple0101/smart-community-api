// src/main/java/com/academy/smartcommunity/repository/QuestionRepository.java
package com.academy.smartcommunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.smartcommunity.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByStudentId(Long studentId);
}
