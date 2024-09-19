package com.example.DangDang.controller;

import com.example.DangDang.DTO.LoginDTO;
import com.example.DangDang.DTO.UserRegisterDTO;
import com.example.DangDang.domain.User;
import com.example.DangDang.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO requestDTO, Model model, HttpSession session) {
        User loginUser = userService.login(requestDTO);

        if (loginUser != null) {
            model.addAttribute("user", loginUser);  // 세션에 로그인 사용자 저장
            session.setAttribute("In", true);         // 세션에 로그인 상태 저장
            System.out.println("첫번째 UserController" + loginUser.getNickName());
            return "redirect:/";  // 로그인 후 리다이렉트 URL 수정
        } else {
            model.addAttribute("user", null);  // 로그인 실패 시 세션에서 사용자 삭제
            session.setAttribute("In", false);   // 로그인 실패 시 세션에 상태 저장
            return "redirect:/";  // 로그인 실패 후 리다이렉트 URL 수정
        }
    }


    @GetMapping("/register")
    public String showRegister(){
        return "user/register.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDTO requestDTO, Model model) {
        String userName = userService.register(requestDTO);
        model.addAttribute("register", userName);
        return "redirect:/";
    }






}
