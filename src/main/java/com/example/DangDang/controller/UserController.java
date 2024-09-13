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

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO requestDTO, Model model, HttpSession session) {
        User loginUser = userService.login(requestDTO);

        if (loginUser != null) {
            session.setAttribute("logIn", loginUser); //세션에 로그인정보 저장
            model.addAttribute("In", true);
            model.addAttribute("logIn", loginUser);
            return "redirect:/";
        }else {
            model.addAttribute("In", false);
            return "redirect:/";
        }
    }




}
