package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // post와의 연관관계
    // DB table : post_id 가져오기
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        setPost(post);
    }

    // 연관관계 편의 메소드
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    public Comment update(CommentRequestDto commentRequestDto){
        this.content = commentRequestDto.getContent();
        return this;
    }
}