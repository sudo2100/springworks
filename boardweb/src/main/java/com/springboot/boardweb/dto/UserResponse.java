package com.springboot.boardweb.dto;

import com.springboot.boardweb.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    // 비밀번호를 제외한 모든 필드 생성(반환)
    private final Long id;
    private final String username;
    private final String role;
    private final LocalDateTime createdAt;

    public UserResponse(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
    }
}
