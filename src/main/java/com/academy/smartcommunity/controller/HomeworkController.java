// src/main/java/com/academy/smartcommunity/controller/HomeworkController.java
package com.academy.smartcommunity.controller;

import com.academy.smartcommunity.model.Homework;
import com.academy.smartcommunity.service.HomeworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/homeworks")
public class HomeworkController {

    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public ResponseEntity<List<Homework>> list(@RequestParam Long studentId) {
        return ResponseEntity.ok(homeworkService.getHomeworksByStudent(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Homework> get(@PathVariable Long id) {
        return ResponseEntity.ok(homeworkService.getHomeworkById(id));
    }

    @PostMapping
    public ResponseEntity<Homework> create(@RequestBody Homework homework) {
        return ResponseEntity.ok(homeworkService.createHomework(homework));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Homework> update(@PathVariable Long id,
                                           @RequestBody Homework homework) {
        return ResponseEntity.ok(homeworkService.updateHomework(id, homework));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        homeworkService.deleteHomework(id);
        return ResponseEntity.noContent().build();
    }
}
