package com.example.demo.myjpasite4.dto;

import com.example.demo.myjpasite4.PostV4;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

// title, content, author를 받아다가 (json으로)
// 우리의 Post로 만드는 역할을 하겠어.
@Getter // 데이터를 다루는 모든 것에는 getter가 있는게 좋음
@NoArgsConstructor // requestbody로부터 데이터를 받아와야함
public class PostCreateRequestDto {

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Length(max = 20, message = "제목은 20자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    @Length(min = 5, message = "내용은 최소 5자 이상이어야 합니다.")
    private String content;

    @Length(min = 2, max = 10, message = "작성자 이름은 2자 이상 10자 이하여야 합니다.")
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
