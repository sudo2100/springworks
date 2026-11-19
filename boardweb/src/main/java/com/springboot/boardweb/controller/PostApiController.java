package com.springboot.boardweb.controller;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.AddPostRequest;
import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 1차 라우팅(도메인)
@RequestMapping("/api/posts")
@AllArgsConstructor
@RestController //@RequestBody (DTO 입력 폼)-필요
public class PostApiController {
    private PostService postService;

    //글 등록
    //ResponseEntity<> - 반환 객체
    @PostMapping
    public ResponseEntity<PostResponse> addPost(@RequestBody AddPostRequest request){
        Post saved = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PostResponse(saved));
    }
}
