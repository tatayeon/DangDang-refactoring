package com.example.DangDang.service;

import com.example.DangDang.DTO.PostAllDTO;
import com.example.DangDang.DTO.ShowDetailDTO;
import com.example.DangDang.domain.Post;
import com.example.DangDang.domain.User;
import com.example.DangDang.repository.PostRepository;
import com.example.DangDang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public String createPost(String title, String content, String username) {
        Optional<User> user = userRepository.findByUserName(username);

        if (user.isPresent()) {
            Post post = Post.builder()
                    .title(title)
                    .content(content)
                    .build();
            post.setUser(user);
            postRepository.save(post);
            return "good";
        }else{
            return "fail";
        }

    }

    public List<PostAllDTO> showAllPost(String username) {
        List<Post> all = postRepository.findAll();
        List<PostAllDTO> postAllDTOList = new ArrayList<>();  // DTO 리스트 생성

        for (Post post : all) {
            PostAllDTO postAllDTO = PostAllDTO.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .auth(username)
                    .build();
            postAllDTOList.add(postAllDTO);  // DTO 리스트에 추가
        }

        return postAllDTOList;  // 리스트 반환
    }

    public ShowDetailDTO showDetailPost(Long id, String username) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            ShowDetailDTO showDetailDTO = ShowDetailDTO.builder()
                    .auth(username)
                    .title(post.get().getTitle())
                    .content(post.get().getContent())
                    .build();

            return showDetailDTO;
        }
        return null;
    }
}
