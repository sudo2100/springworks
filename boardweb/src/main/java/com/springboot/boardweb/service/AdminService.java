package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.domain.User;
import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.repository.PostRepository;
import com.springboot.boardweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    // 회원 총 수
    public long countUsers(){
        return userRepository.count();
    }

    // 게시글 총 수
    public long countPosts(){
        return postRepository.count();
    }

    // 회원 목록
    public List<User> findAllUsers(){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // 게시글 목록 (최신 순 5개)
    public List<Post> findRecentPosts(){
        return postRepository.findAll();
    }
}
