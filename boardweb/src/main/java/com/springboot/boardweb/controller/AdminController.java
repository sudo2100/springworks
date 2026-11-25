package com.springboot.boardweb.controller;

import com.springboot.boardweb.dto.PostResponse;
import com.springboot.boardweb.dto.UserResponse;
import com.springboot.boardweb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;

    // 관리자 홈 - 회원수, 게시글 수, 게시글 목록, 회원 목록
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
                .map(UserResponse::new)
                .toList());

        return "admin/dashboard";
    }

    // 회원 삭제
    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable long id,
                 Principal principal, RedirectAttributes redirectAttributes){
        try{
            adminService.deleteUser(id, principal.getName());
            // redirect 한 다음 화면에 한 번만 값을 전달
            redirectAttributes.addFlashAttribute("message", "회원을 삭제했습니다.");
        }catch (IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin";  //삭제 후 본래 페이지 이동
    }
}
