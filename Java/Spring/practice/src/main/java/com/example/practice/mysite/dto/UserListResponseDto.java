package com.example.practice.mysite.dto;

import com.example.practice.mysite.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserListResponseDto {

    private final Long id;
    private final String nickname;
    private final Boolean isActive;

    public static UserListResponseDto from(User userEntity){
        return UserListResponseDto.builder()
                .id(userEntity.getId())
                .nickname(userEntity.getNickname())
                .isActive(userEntity.getIsActive())
                .build();
    }
}
