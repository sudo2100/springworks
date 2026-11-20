package com.springboot.boardweb.controller;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    // 글 쓰기 화면
    @GetMapping("/new-post")
    public String newPost(){
        return "post/newPost";  //templates/post/newPost.html
    }

    // 글 상세 보기
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id,
                          Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", new PostResponse(post));
        return "post/postDetail"; //templates/post/postDetail.html
    }
}
