// src/main/java/com/academy/smartcommunity/controller/AuthController.java
package com.academy.smartcommunity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.service.AuthService;

/**
 * 인증용 REST API:
 * /api/auth/register : POST → username,password 폼데이터로 가입
 * /api/auth/login    : POST → username,password 폼데이터로 로그인
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String username,
                                         @RequestParam String password) {
        User created = authService.register(username, password);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username,
                                      @RequestParam String password) {
        User user = authService.login(username, password);
        return ResponseEntity.ok(user);
    }
}
