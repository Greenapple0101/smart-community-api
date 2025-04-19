// src/main/java/com/academy/smartcommunity/service/ExamScoreService.java
package com.academy.smartcommunity.service;

import java.util.List;

import com.academy.smartcommunity.model.ExamScore;

public interface ExamScoreService {
    List<ExamScore> getScoresByStudent(Long studentId);
    ExamScore getScoreById(Long id);
    ExamScore createScore(ExamScore examScore);
    ExamScore updateScore(Long id, ExamScore examScore);
    void deleteScore(Long id);
}
