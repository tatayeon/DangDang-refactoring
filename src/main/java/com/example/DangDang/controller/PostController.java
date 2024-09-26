package com.example.DangDang.controller;

import com.example.DangDang.DTO.CreatePostDTO;
import com.example.DangDang.DTO.PostAllDTO;
import com.example.DangDang.DTO.ShowCommentListDTO;
import com.example.DangDang.DTO.ShowDetailDTO;
import com.example.DangDang.domain.Comment;
import com.example.DangDang.domain.Post;
import com.example.DangDang.domain.User;
import com.example.DangDang.service.CommentService;
import com.example.DangDang.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/createPost")
    public String createPost(@RequestParam String title ,@RequestParam String content, HttpSession session) {
        String logInUserName = (String) session.getAttribute("username");
        System.out.println("print CreatePostDTO:" + title);

        String result = postService.createPost(title, content, logInUserName);

        if (result == "good") {
            return "redirect:/post/showAll";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/write")
    public String writePost(@ModelAttribute CreatePostDTO dto, HttpSession session) {
        return "post/write";
    }

    @GetMapping("/showAll")
    public String showAllPosts(Model model, HttpSession session) {
        String logInUserName = (String) session.getAttribute("username");
        List<PostAllDTO> posts = postService.showAllPost(logInUserName);
        model.addAttribute("posts", posts);

        return "post/showAll";
    }

    @GetMapping("/showDetail/{id}")
    public String showDetailPost(@PathVariable Long id, HttpSession session, Model model) {
        String logInUserName = (String) session.getAttribute("username");
        ShowDetailDTO showDetailDTO = postService.showDetailPost(id, logInUserName);
        List<ShowCommentListDTO> comments = commentService.showComment(id, logInUserName);
        model.addAttribute("showDetailDTO", showDetailDTO);
        model.addAttribute("comments", comments);
        System.out.println(showDetailDTO.getTitle());
        System.out.println(showDetailDTO.getContent());
        return "/post/showDetail";
    }


}
