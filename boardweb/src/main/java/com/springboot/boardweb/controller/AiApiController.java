package com.springboot.boardweb.controller;

import com.springboot.boardweb.dto.WritingSuggestionRequest;
import com.springboot.boardweb.dto.WritingSuggestionResponse;
import com.springboot.boardweb.service.WritingAssistantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AiApiController {
    private final WritingAssistantService writingAssistantService;

    @PostMapping("/api/ai-suggestions")
    public ResponseEntity<WritingSuggestionResponse> suggest(
            @RequestBody WritingSuggestionRequest request){
        if(request.question().isBlank()){
            return ResponseEntity.badRequest().build();  //질문 없음
        }
        try{
            return ResponseEntity.ok(writingAssistantService.getWritingAssist(request));
        }catch(Exception e){
            log.warn("AI 호출 실패: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
