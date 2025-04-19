// src/main/java/com/academy/smartcommunity/SmartCommunityApiApplication.java
package com.academy.smartcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 애플리케이션 진입점. SpringBootApplication 어노테이션으로 컴포넌트 스캔과 자동설정 활성화.
 */
@SpringBootApplication
public class SmartCommunityApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartCommunityApiApplication.class, args);
    }
}
