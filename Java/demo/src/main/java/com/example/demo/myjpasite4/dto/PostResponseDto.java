package com.example.demo.myjpasite4.dto;

import com.example.demo.myjpasite4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // Allargusconstructor 생성됨
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;

    public static PostResponseDto from(PostV4 entity){
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
        // return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(),entity.getAuthor())
    }
}
