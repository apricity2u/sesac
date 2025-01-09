package com.example.practice.mysite.domain.user.dto;

import com.example.practice.mysite.domain.team.Team;
import com.example.practice.mysite.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UserResponseDto {

    private final Long id;
    private final String username;
    private final String email;
    private final String nickname;
    private final Integer age;
    private final Boolean isActive;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static UserResponseDto from(User userEntity){
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .nickname(userEntity.getNickname())
                .age(userEntity.getAge())
                .isActive(userEntity.getIsActive())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }

}
