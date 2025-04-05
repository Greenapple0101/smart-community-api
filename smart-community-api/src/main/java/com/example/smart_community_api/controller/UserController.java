package com.example.smart_community_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smart_community_api.domain.User;
import com.example.smart_community_api.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // 회원가입 페이지 GET 요청
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; // register.html
    }
    
    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.register(user);
            return "redirect:/custom-login-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    
    // 프로필 관련 매핑이 중복되므로, 여기에 프로필 관련 메서드는 제거합니다.
}
