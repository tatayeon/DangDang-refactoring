package com.example.DangDang.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostAllDTO {
    private long id;

    private String title;

    private String content;

    private String auth;

    public PostAllDTO(long id, String title, String content, String auth) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.auth = auth;
    }
}
