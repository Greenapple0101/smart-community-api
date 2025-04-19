// src/main/java/com/academy/smartcommunity/repository/UserRepository.java
package com.academy.smartcommunity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.smartcommunity.model.User;

/**
 * User 조회/저장 전용 JPA 리포지토리.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
