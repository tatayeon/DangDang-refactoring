package com.example.DangDang.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShowDetailDTO {

    private String auth;

    private String title;

    private String content;

    private long postId;

    public ShowDetailDTO(String auth, String title, String content, long postId) {
        this.auth = auth;
        this.title = title;
        this.content = content;
        this.postId = postId;
    }

}
