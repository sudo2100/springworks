package com.springboot.boardweb.repository;

import com.springboot.boardweb.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // save(), findById(), deleteById()
    // 검색 : 검색어가 포함된 글을 최신순으로 조회
    List<Post> findByTitleContainingOrderByIdDesc(String keyword); //제목
    List<Post> findByContentContainingOrderByIdDesc(String keyword); //내용
    List<Post> findByWriterContainingOrderByIdDesc(String keyword); //글쓴이
}
