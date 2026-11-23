package com.springboot.boardweb.controller;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.AddPostRequest;
import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.dto.UpdatePostRequest;
import com.springboot.boardweb.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

// 1차 라우팅(도메인)
@RequestMapping("/api/posts")
@AllArgsConstructor
@RestController //@RequestBody (DTO 입력 폼)-필요
public class PostApiController {
    private PostService postService;

    //글 등록
    //ResponseEntity<> - 반환 객체
    @PostMapping
    public ResponseEntity<PostResponse> addPost(@RequestBody AddPostRequest request,
                                                Principal principal){
        Post saved = postService.save(request, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new PostResponse(saved));
    }

    // 글 목록
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAllPosts(){
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok().body(posts);
    }

    // 글 상세 보기
    @GetMapping("/{id}")  //@PathVariable - 경로의 특정값을 가져옴
    public ResponseEntity<PostResponse> findPost(@PathVariable Long id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(new PostResponse(post));
    }

    // 글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.ok().build(); //반환할 객체가 없어서 body() 없음(1을 반환)
    }

    // 글 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long id,
                                                   @RequestBody UpdatePostRequest request){
        Post post = postService.update(id, request);  //수정한 게시글
        return ResponseEntity.ok().body(new PostResponse(post));
    }
}
