package com.springboot.boardweb.repository;

import com.springboot.boardweb.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // save(), findById(), deleteById()
}
