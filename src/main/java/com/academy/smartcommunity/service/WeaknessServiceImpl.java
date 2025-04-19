// src/main/java/com/academy/smartcommunity/service/WeaknessServiceImpl.java
package com.academy.smartcommunity.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.model.Weakness;
import com.academy.smartcommunity.repository.UserRepository;
import com.academy.smartcommunity.repository.WeaknessRepository;

@Service
@Transactional
public class WeaknessServiceImpl implements WeaknessService {

    private final WeaknessRepository repo;
    private final UserRepository       userRepo;

    public WeaknessServiceImpl(WeaknessRepository repo,
                               UserRepository userRepo) {
        this.repo     = repo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Weakness> getWeaknessesByStudent(Long studentId) {
        userRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + studentId));
        return repo.findByStudentId(studentId);
    }

    @Override
    public Weakness getWeaknessById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new IllegalArgumentException("약점을 찾을 수 없습니다. id=" + id));
    }

    @Override
    public Weakness createWeakness(Weakness weakness) {
        Long sid = weakness.getStudent().getId();
        User student = userRepo.findById(sid)
                               .orElseThrow(() -> new IllegalArgumentException("학생이 없습니다. id=" + sid));
        weakness.setStudent(student);
        return repo.save(weakness);
    }

    @Override
    public Weakness updateWeakness(Long id, Weakness weakness) {
        Weakness existing = getWeaknessById(id);
        existing.setDescription(weakness.getDescription());
        existing.setPriority(weakness.getPriority());
        return repo.save(existing);
    }

    @Override
    public void deleteWeakness(Long id) {
        repo.deleteById(id);
    }
}
