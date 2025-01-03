package com.example.demo.myjpasite4.dto;

import com.example.demo.myjpasite4.PostV4;
import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author를 받아다가 (json으로)
// 우리의 Post로 만드는 역할을 하겠어.
@Getter // 데이터를 다루는 모든 것에는 getter가 있는게 좋음
@NoArgsConstructor // requestbody로부터 데이터를 받아와야함
public class PostCreateRequestDto {

    private String title;
    private String content;
    private String author;

    // 내가 가진 필드를 가지고 완전 새로운 것을 생성
    public PostV4 toEntity(){
        return PostV4.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
        // return new PostV4(title, content, author);
    }
}
