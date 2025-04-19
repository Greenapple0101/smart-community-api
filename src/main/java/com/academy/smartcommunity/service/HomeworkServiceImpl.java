// src/main/java/com/academy/smartcommunity/service/HomeworkServiceImpl.java
package com.academy.smartcommunity.service;

import com.academy.smartcommunity.model.Homework;
import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.repository.HomeworkRepository;
import com.academy.smartcommunity.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final UserRepository userRepository;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository,
                               UserRepository userRepository) {
        this.homeworkRepository = homeworkRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Homework> getHomeworksByStudent(Long studentId) {
        userRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + studentId));
        return homeworkRepository.findByStudentId(studentId);
    }

    @Override
    public Homework getHomeworkById(Long id) {
        return homeworkRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("숙제를 찾을 수 없습니다. id=" + id));
    }

    @Override
    public Homework createHomework(Homework homework) {
        Long sid = homework.getStudent().getId();
        User student = userRepository.findById(sid)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + sid));
        homework.setStudent(student);
        return homeworkRepository.save(homework);
    }

    @Override
    public Homework updateHomework(Long id, Homework homework) {
        Homework existing = getHomeworkById(id);
        existing.setTitle(homework.getTitle());
        existing.setDescription(homework.getDescription());
        existing.setDueDate(homework.getDueDate());
        existing.setCompleted(homework.isCompleted());
        return homeworkRepository.save(existing);
    }

    @Override
    public void deleteHomework(Long id) {
        homeworkRepository.deleteById(id);
    }
}
