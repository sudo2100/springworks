package com.springboot.boardweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "<h1>My Board Web</h1>";
    }
}
