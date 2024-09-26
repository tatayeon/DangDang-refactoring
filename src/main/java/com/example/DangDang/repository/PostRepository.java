package com.example.DangDang.repository;

import com.example.DangDang.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);

}
