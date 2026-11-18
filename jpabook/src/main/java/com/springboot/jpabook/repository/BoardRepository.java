package com.springboot.jpabook.repository;

import com.springboot.jpabook.domain.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<T, ID>
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // save(), findAll(), findById(), deleteById() : 저장, 목록 조회, 단건 조회, 삭제
    // find + 엔티티이름(생략가능) + By + 변수이름(필드 이름)
    // 제목으로 검색
    List<Board> findByTitle(String searchKeyword);

    // 특정 단어가 포함된 글 내용 검색 - Like
    List<Board> findByContentContaining(String searchKeyword);

    // 제목 또는 내용에 특정 단어가 포함된 목록 검색 -
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // 글 제목에 특정 단어가 포함된 글 목록을 내림차순으로 검색
    List<Board> findByTitleContainingOrderByIdDesc(String searchKeyword);

    // 제목 검색어가 포함된 게시글 목록을 페이지 처리하여 조회
    List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}
