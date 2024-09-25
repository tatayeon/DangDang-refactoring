package com.example.DangDang.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShowDetailDTO {

    private String auth;

    private String title;

    private String content;

    public ShowDetailDTO(String auth, String title, String content) {
        this.auth = auth;
        this.title = title;
        this.content = content;
    }

}
