// 파일 위치: src/main/java/com/academy/smartcommunity/dto/UserDto.java
package com.academy.smartcommunity.dto;

/**
 * User 정보를 외부에 노출할 때 쓰는 DTO (password 제외)
 */
public class UserDto {
    private Long id;
    private String username;

    public UserDto() {}

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
