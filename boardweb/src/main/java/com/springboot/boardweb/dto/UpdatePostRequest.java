package com.springboot.boardweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 글 수정 요청 DTO
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
}
