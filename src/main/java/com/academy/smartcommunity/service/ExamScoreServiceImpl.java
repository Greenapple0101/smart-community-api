// src/main/java/com/academy/smartcommunity/service/ExamScoreServiceImpl.java
package com.academy.smartcommunity.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.smartcommunity.model.ExamScore;
import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.repository.ExamScoreRepository;
import com.academy.smartcommunity.repository.UserRepository;

@Service
@Transactional
public class ExamScoreServiceImpl implements ExamScoreService {

    private final ExamScoreRepository repo;
    private final UserRepository        userRepo;

    public ExamScoreServiceImpl(ExamScoreRepository repo,
                                UserRepository userRepo) {
        this.repo     = repo;
        this.userRepo = userRepo;
    }

    @Override
    public List<ExamScore> getScoresByStudent(Long studentId) {
        userRepo.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + studentId));
        return repo.findByStudentId(studentId);
    }

    @Override
    public ExamScore getScoreById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("시험 기록을 찾을 수 없습니다. id=" + id));
    }

    @Override
    public ExamScore createScore(ExamScore examScore) {
        Long sid = examScore.getStudent().getId();
        User student = userRepo.findById(sid)
            .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + sid));
        examScore.setStudent(student);
        return repo.save(examScore);
    }

    @Override
    public ExamScore updateScore(Long id, ExamScore examScore) {
        ExamScore existing = getScoreById(id);
        existing.setSubject(examScore.getSubject());
        existing.setScore(examScore.getScore());
        existing.setExamDate(examScore.getExamDate());
        return repo.save(existing);
    }

    @Override
    public void deleteScore(Long id) {
        repo.deleteById(id);
    }
}
