package com.example.demo.myjpasite4.dto;

import com.example.demo.myjpasite4.PostV4;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder // Allargusconstructor 생성됨
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static PostResponseDto from(PostV4 entity){
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
        // return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(),entity.getAuthor())
    }
}
