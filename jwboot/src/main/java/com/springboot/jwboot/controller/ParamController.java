package com.springboot.jwboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
    // @RequestParam - ?이름=값 형태로 보내는 데이터다.
    @GetMapping("/ex01")
    public String requestParam(@RequestParam("id") String userId,
                               @RequestParam("pw") String userPw,
                               Model model){
        model.addAttribute("data1", "@RequestParam 예제");
        model.addAttribute("data2", "id: " + userId + "<br>pw: " + userPw);
        return "views/viewPage01";
    }

    // @PathVariable - URL 안에 들어있는 값을 받을 때 쓴다.
    @GetMapping("/boards/{id}")
    public String pathVariable(@PathVariable("id") Long id,
                               Model model){
        model.addAttribute("data1", "@PathVariable 예제");
        model.addAttribute("data2", "글번호: " + id);
        return "views/viewPage02";
    }
}
