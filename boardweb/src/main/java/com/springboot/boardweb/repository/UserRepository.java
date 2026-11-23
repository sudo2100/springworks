package com.springboot.boardweb.repository;

import com.springboot.boardweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 회원 가입시 중복 확인
    boolean existsByUsername(String username);

    // 아이디로 회원 조회(Optional - 아이디 없을때 null 처리 됨)
    Optional<User> findByUsername(String username);
}
