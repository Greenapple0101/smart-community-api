package com.academy.smartcommunity.service;

import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AuthService의 구현체를 service 패키지에 직접 둔 버전
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String rawPassword) {
        userRepository.findByUsername(username)
            .ifPresent(u -> { throw new IllegalArgumentException("이미 존재하는 사용자입니다: " + username); });
        String encoded = passwordEncoder.encode(rawPassword);
        User user = new User(username, encoded);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String rawPassword) {
        return userRepository.findByUsername(username)
            .filter(u -> passwordEncoder.matches(rawPassword, u.getPassword()))
            .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 올바르지 않습니다."));
    }
}
