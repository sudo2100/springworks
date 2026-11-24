package com.springboot.boardweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice  //모든 컨트롤러에 적용
public class LoginUserAdvice {

    // 모든 화면의 모델에 "loginUser" 추가
    @ModelAttribute("loginUser")
    public String loginUser(Principal principal){
        // 로그인한 아이디 - principal.getName(), 없으면 : null
        return principal == null ? null : principal.getName();
    }

    // 관리자 메뉴 보임
    @ModelAttribute("isAdmin")
    public boolean isAdmin(HttpServletRequest request){
        return request.isUserInRole("ADMIN");  //ROLE_ADMIN
    }
}
