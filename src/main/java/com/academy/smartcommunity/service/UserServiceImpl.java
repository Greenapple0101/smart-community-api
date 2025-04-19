// 파일 위치: src/main/java/com/academy/smartcommunity/service/UserServiceImpl.java
package com.academy.smartcommunity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.smartcommunity.dto.UserDto;
import com.academy.smartcommunity.model.User;
import com.academy.smartcommunity.repository.UserRepository;

/**
 * UserService 구현체: UserRepository에서 User를 꺼내 DTO로 변환
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + id));
        return new UserDto(user.getId(), user.getUsername());
    }
}
