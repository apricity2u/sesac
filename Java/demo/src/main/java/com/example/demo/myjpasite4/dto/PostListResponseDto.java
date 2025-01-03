package com.example.demo.myjpasite4.dto;

import com.example.demo.myjpasite4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // Allargusconstructor 생성됨
public class PostListResponseDto {
    private final Long id;
    private final String title;

    // 게시글 목록에는 제목 정도만 보이니까 id, title만 넣음
    public static PostListResponseDto from(PostV4 entity){
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
