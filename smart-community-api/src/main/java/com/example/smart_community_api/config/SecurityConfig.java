package com.example.smart_community_api.config;

import com.example.smart_community_api.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/", "/custom-login-page", "/users/register", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage("/custom-login-page")
                    .loginProcessingUrl("/perform_login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/users/profile", true)
                    .permitAll()
            .and()
                .logout()
                    .logoutSuccessUrl("/custom-login-page")
                    .permitAll();

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
