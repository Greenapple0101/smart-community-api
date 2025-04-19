package com.academy.smartcommunity.service;

import java.util.List;

import com.academy.smartcommunity.model.Homework;

public interface HomeworkService {
    List<Homework> getHomeworksByStudent(Long studentId);
    Homework getHomeworkById(Long id);
    Homework createHomework(Homework homework);
    Homework updateHomework(Long id, Homework homework);
    void deleteHomework(Long id);
}
