// 파일 위치: src/main/java/com/academy/smartcommunity/controller/UserController.java
package com.academy.smartcommunity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.smartcommunity.dto.UserDto;
import com.academy.smartcommunity.service.UserService;

/**
 * 사용자 프로필 조회용 REST 컨트롤러
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** 
     * GET /api/users/{id}
     * 요청한 ID의 사용자 프로필 반환
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        UserDto dto = userService.getUserById(id);
        return ResponseEntity.ok(dto);
    }
}
