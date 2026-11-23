package com.springboot.boardweb.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String role;

    @CreatedDate
    private LocalDateTime createdAt;

    // 생성자 (Builder)
    @Builder
    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
