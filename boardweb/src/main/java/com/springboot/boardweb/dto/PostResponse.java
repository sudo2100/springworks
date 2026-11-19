package com.springboot.boardweb.dto;

import com.springboot.boardweb.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

// 반환 DTO(DB에서 데이터 가져옴)
@Getter
public class PostResponse {
     private final Long id;
     private final String title;
     private final String content;
     private final String writer;
     private final LocalDateTime createdAt;
     private final LocalDateTime updatedAt;

     // 엔티티 -> DTO => 객체 생성자
     public PostResponse(Post post){
         this.id = post.getId();
         this.title = post.getTitle();
         this.content = post.getContent();
         this.writer = post.getWriter();
         this.createdAt = post.getCreatedAt();
         this.updatedAt = post.getUpdatedAt();
     }
}
