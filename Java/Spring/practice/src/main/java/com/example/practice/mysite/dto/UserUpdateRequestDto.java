package com.example.practice.mysite.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private String email;
    private String nickname;
    private Integer age;
    private Boolean isActive;

}
