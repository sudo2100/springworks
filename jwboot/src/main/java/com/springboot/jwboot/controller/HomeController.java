package com.springboot.jwboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController   // 문자열 반환
public class HomeController {

    @GetMapping("/")
    public String home(){
        //return "<h1>Spring Boot 프레임워크 스터디</h1>";
        return "index";  // templates/index.html
    }

    @GetMapping("/time")
    public String time(){
        return "pages/time";  //templates/pages/time.html
    }
}
