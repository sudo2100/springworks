package com.springboot.jpabook.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor // 전체 필드 생성자
@NoArgsConstructor  // 기본 생성자
@ToString
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(length = 2000, nullable = false)
    private  String content;

    @CreatedDate
    private LocalDateTime createdAt;
}
