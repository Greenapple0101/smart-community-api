// src/main/java/com/academy/smartcommunity/controller/ExamScoreController.java
package com.academy.smartcommunity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.smartcommunity.model.ExamScore;
import com.academy.smartcommunity.service.ExamScoreService;

@RestController
@RequestMapping("/api/examscores")
public class ExamScoreController {

    private final ExamScoreService service;

    public ExamScoreController(ExamScoreService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExamScore>> list(@RequestParam Long studentId) {
        return ResponseEntity.ok(service.getScoresByStudent(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamScore> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScoreById(id));
    }

    @PostMapping
    public ResponseEntity<ExamScore> create(@RequestBody ExamScore examScore) {
        return ResponseEntity.ok(service.createScore(examScore));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamScore> update(@PathVariable Long id,
                                            @RequestBody ExamScore examScore) {
        return ResponseEntity.ok(service.updateScore(id, examScore));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
