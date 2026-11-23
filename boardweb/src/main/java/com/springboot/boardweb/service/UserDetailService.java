package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.User;
import com.springboot.boardweb.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인 조회 - 시큐리티가 호출하는 함수 : 아이디로 찾아 넘겨준다.
    // 시큐리티에 자체 User 클래스 존재
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 아이디가 존재하는 User 객체 가져오기
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())  // USER -> 권한 ROLE_USER
                .build();
    }
}
