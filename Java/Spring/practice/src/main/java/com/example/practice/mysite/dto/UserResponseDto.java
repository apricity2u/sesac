package com.example.practice.mysite.dto;

import com.example.practice.mysite.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDto {

    private final Long id;
    private final String username;
    private final String email;
    private final String nickname;
    private final Integer age;
    private final Boolean isActive;

    public static UserResponseDto from(User userEntity){
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .nickname(userEntity.getNickname())
                .age(userEntity.getAge())
                .isActive(userEntity.getIsActive())
                .build();
    }

}
