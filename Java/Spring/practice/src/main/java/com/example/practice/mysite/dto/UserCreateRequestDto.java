package com.example.practice.mysite.dto;

import com.example.practice.mysite.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    private String username;
    private String email;
    private String nickname;
    private Integer age;

    public User toEntity(){
        return User.builder()
                .username(this.getUsername())
                .email(this.getEmail())
                .nickname(this.getNickname())
                .age(this.getAge())
                .build();
    }

}
