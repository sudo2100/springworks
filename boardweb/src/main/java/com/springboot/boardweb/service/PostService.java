package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.AddPostRequest;
import com.springboot.boardweb.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor  // 생성자 주입
@Service
public class PostService {
    private PostRepository postRepository;

    // 글 등록
    public Post save(AddPostRequest request){
        // 게시글이 DB에 저장
       return postRepository.save(request.toEntity());
    }
}
