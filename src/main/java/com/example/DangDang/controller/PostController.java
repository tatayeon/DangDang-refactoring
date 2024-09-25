package com.example.DangDang.controller;

import com.example.DangDang.DTO.CreatePostDTO;
import com.example.DangDang.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute CreatePostDTO dto) {


    }


}
