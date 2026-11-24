package com.springboot.boardweb.controller;

import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;

    // 관리자 홈
    @GetMapping
    public String dashboard(Model model){
        model.addAttribute("userCount", adminService.countUsers());
        model.addAttribute("postCount", adminService.countPosts());
        model.addAttribute("recentPosts", adminService.findRecentPosts()
                .stream()
                .map(PostResponse::new)
                .toList());
        model.addAttribute("users", adminService.findAllUsers()
                .stream()
                .map()
                .toList());

        return "admin/dashboard";
    }
}
