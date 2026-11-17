package com.springboot.jwboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mapper")
@Controller
public class Exam01Controller {

    @GetMapping("/exam01")
    public String exam01(Model model){
        // 뷰에 보낼 데이터를 Model 담는다 ("이름", 값)
        model.addAttribute("title", "RequestMapping 예제");
        model.addAttribute("url", "/exam01");
        return "pages/view01";

    }
}
