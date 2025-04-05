package com.example.smart_community_api.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/users/profile")
    public String showProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // 로그인한 사용자의 이메일을 기반으로 DB 조회 등 추가 가능
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("message", "환영합니다! 개인 프로필 페이지입니다.");
        return "profile"; // profile.html 템플릿
    }
}
