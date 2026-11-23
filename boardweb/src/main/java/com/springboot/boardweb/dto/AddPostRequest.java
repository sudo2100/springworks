package com.springboot.boardweb.dto;

import com.springboot.boardweb.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPostRequest {
    private String title;
    private String content;
    //private String writer; //삭제

    // DTO -> Entity(DB의 post table), 글쓴이는 서버가 넘겨준다.
    public Post toEntity(String writer){
        return Post.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
