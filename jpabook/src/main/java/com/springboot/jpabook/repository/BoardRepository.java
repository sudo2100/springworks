package com.springboot.jpabook.repository;

import com.springboot.jpabook.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<T, ID>
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // save(), findAll(), findById(), deleteById() : 저장, 목록 조회, 단건 조회, 삭제
    // find + 엔티티이름(생략가능) + By + 변수이름
    List<Board> findByTitle(String searchKeyword);
}
