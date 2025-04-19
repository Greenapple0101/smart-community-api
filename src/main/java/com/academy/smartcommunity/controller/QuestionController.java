// src/main/java/com/academy/smartcommunity/controller/QuestionController.java
package com.academy.smartcommunity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.smartcommunity.dto.AnswerDto;
import com.academy.smartcommunity.model.Question;
import com.academy.smartcommunity.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    /** 학생별 질문 목록 조회 */
    @GetMapping
    public ResponseEntity<List<Question>> list(@RequestParam Long studentId) {
        return ResponseEntity.ok(service.getQuestionsByStudent(studentId));
    }

    /** 특정 질문 상세 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<Question> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getQuestionById(id));
    }

    /** 새 질문 등록 */
    @PostMapping
    public ResponseEntity<Question> ask(@RequestBody Question question) {
        return ResponseEntity.ok(service.askQuestion(question));
    }

    /** 질문에 답변 달기 */
    @PostMapping("/{id}/answer")
    public ResponseEntity<Question> answer(@PathVariable Long id,
                                           @RequestBody AnswerDto dto) {
        return ResponseEntity.ok(service.answerQuestion(id, dto.getAnswer()));
    }
}
