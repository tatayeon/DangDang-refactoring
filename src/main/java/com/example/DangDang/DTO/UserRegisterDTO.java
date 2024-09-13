package com.example.DangDang.DTO;

import lombok.Getter;

@Getter
public class UserRegisterDTO {

    private String userName;
    private String password;
    private String nickName;

    public UserRegisterDTO(String userName, String password, String nickName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }
}
