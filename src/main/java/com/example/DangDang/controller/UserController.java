package com.example.DangDang.controller;

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
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        System.out.println("username: " + username);
        String result = userService.login(username, password);

        System.out.println("loginUser controlloer: " + result);

        if (result == "succes") {
            session.setAttribute("username", username);
            model.addAttribute("user", result);
            session.setAttribute("In", true);
            System.out.println("첫번째 UserController" + result);
            return "redirect:/";
        } else {
            model.addAttribute("user", null);
            session.setAttribute("In", false);
            return "redirect:/";
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

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("In", false);
        return "redirect:/";
    }




}
