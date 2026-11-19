package com.springboot.boardweb.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@EntityListeners(AuditingEntityListener.class) //@CreatedDate, @LastModifiedDate
@AllArgsConstructor  // 전체 필드 생성자
@NoArgsConstructor  //기본생성자
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //번호

    @Column(nullable = false)
    private String title;  //제목

    @Column(length = 30, nullable = false)
    private String writer; //글쓴이

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  //글내용

    @CreatedDate
    private LocalDateTime createdAt;  //작성일

    @LastModifiedDate
    private LocalDateTime updatedAt;  //수정일

    //빌더 패턴으로 객체 생성
    /*@Builder
    public Post(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }*/

    // 요청 받은 값으로 수정
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
