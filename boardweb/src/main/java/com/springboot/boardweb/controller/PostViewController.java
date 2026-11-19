package com.springboot.boardweb.controller;

import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor // 변수에 final을 반드시 붙임
@Controller
public class PostViewController {
    private final PostService postService;  //생성자 주입방식으로 객체 생성

    // 글 목록 화면
    @GetMapping("/posts")
    public String getPosts(Model model){
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
        model.addAttribute("posts", posts); // 게시글을 글목록으로 보냄
        return "post/postList";  //templates/post/postList.html
    }
}
