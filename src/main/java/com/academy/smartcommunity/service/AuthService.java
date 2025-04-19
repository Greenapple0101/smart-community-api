// src/main/java/com/academy/smartcommunity/service/AuthService.java
package com.academy.smartcommunity.service;

import com.academy.smartcommunity.model.User;

/**
 * 인증 관련 비즈니스 로직 인터페이스.
 */
public interface AuthService {
    /**
     * 신규 사용자 등록 (아이디 중복 검사 + 비밀번호 암호화)
     */
    User register(String username, String rawPassword);

    /**
     * 로그인 (아이디/비밀번호 검증)
     */
    User login(String username, String rawPassword);
}
