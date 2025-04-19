// src/main/java/com/academy/smartcommunity/service/QuestionService.java
package com.academy.smartcommunity.service;

import java.util.List;

import com.academy.smartcommunity.model.Question;

public interface QuestionService {
    List<Question> getQuestionsByStudent(Long studentId);
    Question getQuestionById(Long id);
    Question askQuestion(Question question);
    Question answerQuestion(Long id, String answer);
}
