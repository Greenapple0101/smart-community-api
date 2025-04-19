// 파일 위치: src/main/java/com/academy/smartcommunity/service/UserService.java
package com.academy.smartcommunity.service;

import com.academy.smartcommunity.dto.UserDto;

/**
 * 사용자 조회용 서비스 인터페이스
 */
public interface UserService {
    /**
     * 주어진 ID의 사용자 프로필을 조회합니다.
     * @param id 조회할 사용자 ID
     * @return 패스워드를 제외한 UserDto
     */
    UserDto getUserById(Long id);
}
