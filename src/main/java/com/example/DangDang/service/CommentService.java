package com.example.DangDang.service;

import com.example.DangDang.DTO.ShowCommentListDTO;
import com.example.DangDang.domain.Comment;
import com.example.DangDang.domain.Post;
import com.example.DangDang.domain.User;
import com.example.DangDang.repository.CommentRepository;
import com.example.DangDang.repository.PostRepository;
import com.example.DangDang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createComment(String commentContent, String username, long postId) {
        Post post = postRepository.findById(postId);

        Optional<User> user = userRepository.findByUserName(username);

        System.out.println("commentService createComment");
        System.out.println(postId);
        System.out.println(username);

        if(user.isPresent()) {
            Comment comment = Comment.builder()
                    .commentContent(commentContent)
                    .post(post)
                    .build();
            comment.setUser(user);
            commentRepository.save(comment);
        }


    }



    public List<ShowCommentListDTO> showComment(Long id, String loginUserId) {
        List<Comment> comments = commentRepository.findByPostId(id);
        List<ShowCommentListDTO> showCommentListDTOS = new ArrayList<>();

        for (Comment comment : comments) {
            ShowCommentListDTO showCommentListDTO = ShowCommentListDTO
                    .builder()
                    .comment(comment.getCommentContent())
                    .username(loginUserId)
                    .build();
            showCommentListDTOS.add(showCommentListDTO);
        }

        return showCommentListDTOS;
    }
}
