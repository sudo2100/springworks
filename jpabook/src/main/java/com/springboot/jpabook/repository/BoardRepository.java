package com.springboot.jpabook.repository;

import com.springboot.jpabook.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<T, ID>
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // save(), findAll(), findById(), deleteById() : 저장, 목록 조회, 단건 조회, 삭제
}
