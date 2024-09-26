package com.example.DangDang.controller;

import com.example.DangDang.domain.Comment;
import com.example.DangDang.service.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/createComment/{postId}")
    public String createComment(@RequestParam String commentContent, @PathVariable long postId, HttpSession session) {
        String logInUserName = (String) session.getAttribute("username");
        System.out.println("print commentContent" + commentContent);
        commentService.createComment(commentContent, logInUserName, postId);

        return "redirect:/post/showDetail/" + postId;  // 올바른 리디렉션 경로
    }


}
