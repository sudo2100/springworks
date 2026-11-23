package com.springboot.boardweb.controller;

import com.springboot.boardweb.dto.AddUserRequest;
import com.springboot.boardweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    // 회원 가입 폼 페이지
    @GetMapping("/signup")
    public String signupForm(){
        return "user/signup";
    }

    // 회원 가입 처리
    @PostMapping("/signup")
    public String signup(AddUserRequest request, Model model){
        try{
            // 정상 - 회원 가입
            userService.save(request);
        }catch (IllegalArgumentException e){
            // 오류 - 오류 문자 보내기
            model.addAttribute("error", e.getMessage());
            model.addAttribute("username", request.getUsername());
            return "user/signup";  // 다시 가입 화면
        }
        return "redirect:/login?signup";  //redirect: 즉시 이동(새로고침 방지)
    }

    // 로그인 폼 페이지
    @GetMapping("/login")
    public String loginForm(){
        return "user/login";
    }

}
