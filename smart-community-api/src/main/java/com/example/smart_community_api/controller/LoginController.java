package com.example.smart_community_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/custom-login-page")
    public String login() {
        return "login"; // src/main/resources/templates/login.html
    }
}
