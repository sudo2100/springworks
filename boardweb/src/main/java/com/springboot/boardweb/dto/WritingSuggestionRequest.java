package com.springboot.boardweb.dto;

import java.util.Map;

public record WritingSuggestionRequest(String title, String content, String question) {

    // 압축 생성자
    public WritingSuggestionRequest{
        title = (title == null) ? "" : title;
        content = (content == null) ? "" : content;
        question = (question == null) ? "" : question;
    }

    // 템플릿 자리에 넣을 값 - 자료구조(Map)
    public Map<String, Object> toMap(String format){
        return Map.of("title", title, "content",
                content, "question", question, "format", format);
    }
}
