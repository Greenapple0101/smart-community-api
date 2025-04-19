// src/main/java/com/academy/smartcommunity/repository/HomeworkRepository.java
package com.academy.smartcommunity.repository;

import com.academy.smartcommunity.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    List<Homework> findByStudentId(Long studentId);
}
