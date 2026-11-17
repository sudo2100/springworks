package com.springboot.jpabook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "<h2>Spring Data Jpa Test</h2>";
    }
}
