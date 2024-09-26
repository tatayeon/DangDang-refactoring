package com.example.DangDang.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ShowCommentListDTO {

    private String username;

    private String comment;

    private String authName;

    @Builder
    public ShowCommentListDTO(String username, String comment, String authName) {
        this.username = username;
        this.comment = comment;
        this.authName = authName;
    }

}
