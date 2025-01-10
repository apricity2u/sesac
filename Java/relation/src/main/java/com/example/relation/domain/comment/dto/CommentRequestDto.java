package com.example.relation.domain.comment.dto;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.post.entity.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @NotBlank
    private String content;

    // 외부에서 post에 대한 정보가 필요하니까, 인자로 받기
    public Comment toEntity(Post post){
        return Comment.builder()
                .content(this.content)
                .post(post)
                .build();
    }

}
