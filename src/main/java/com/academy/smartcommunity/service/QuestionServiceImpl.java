// src/main/java/com/academy/smartcommunity/service/QuestionServiceImpl.java
package com.academy.smartcommunity.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.smartcommunity.model.Question;
import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.repository.QuestionRepository;
import com.academy.smartcommunity.repository.UserRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repo;
    private final UserRepository     userRepo;

    public QuestionServiceImpl(QuestionRepository repo,
                               UserRepository userRepo) {
        this.repo     = repo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Question> getQuestionsByStudent(Long studentId) {
        userRepo.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + studentId));
        return repo.findByStudentId(studentId);
    }

    @Override
    public Question getQuestionById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("질문을 찾을 수 없습니다. id=" + id));
    }

    @Override
    public Question askQuestion(Question question) {
        Long sid = question.getStudent().getId();
        User student = userRepo.findById(sid)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + sid));
        question.setStudent(student);
        question.setStatus("PENDING");
        return repo.save(question);
    }

    @Override
    public Question answerQuestion(Long id, String answer) {
        Question q = getQuestionById(id);
        q.setAnswer(answer);
        q.setStatus("ANSWERED");
        return repo.save(q);
    }
}
