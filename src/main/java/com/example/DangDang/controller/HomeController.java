package com.example.DangDang.controller;

import com.example.DangDang.domain.Result;
import com.example.DangDang.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showIndex(Model model, HttpSession session) throws JsonProcessingException {
        User logIn = new User();
        if(model.getAttribute("user") != null){
            logIn = (User) session.getAttribute("logIn");

        }
        if(session.getAttribute("In") != null){
            session.setAttribute("In", true);
        }
        model.addAttribute("user", logIn);
        System.out.println("User: " + logIn.getNickName());
        String re = (String) session.getAttribute("re");
        String fileName = (String) session.getAttribute("fileName");
        model.addAttribute("re", re);
        model.addAttribute("fileName", fileName);

        if (logIn != null) {
            System.out.println("list" + session.getAttribute("re"));
            if (session.getAttribute("re") != null) {
                String jsonStr = (String) session.getAttribute("re");
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Result>>(){}.getType();
                ArrayList<Result> list = gson.fromJson(jsonStr, type);
                System.out.println("list2=" + list);
                model.addAttribute("list", list);
            }
            return "index";
        }
        model.addAttribute("In", false); // 로그인하지 않은 경우
        return "index";
    }

}
