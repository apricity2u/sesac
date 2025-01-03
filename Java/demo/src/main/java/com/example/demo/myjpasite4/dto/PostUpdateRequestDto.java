package com.example.demo.myjpasite4.dto;

import lombok.Getter;

@Getter // 데이터를 다루는 모든 것에는 getter가 있는게 좋음
// @NoArgsConstructor 필요하지만 이 경우는 기본 생성자를 자동으로 만들어주기 때문에 필요없음
public class PostUpdateRequestDto {

    private String title;
    private String content;

    // DTO를 가지고 이미 존재하는 post를 수정
    // builder는 새로운 것을 생성하는 것이라, toEntity는 없앰
}
