package com.example.DangDang.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    private String commentContent;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Comment(String commentContent, Post post, User user) {
        this.commentContent = commentContent;
        this.post = post;
        this.user = user;
    }

    public void setUser(Optional<User> user) {
        this.user = user.orElse(null);
    }

    public void setPost(Optional<Post> post) {
        this.post = post.orElse(null);
    }



}
