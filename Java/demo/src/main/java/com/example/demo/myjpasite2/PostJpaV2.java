package com.example.demo.myjpasite2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 테이블과 연결할 것
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaV2 {

    @Id // 테이블의 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키는 1, 2, 3, 4 순서대로 만들어짐
    private Long id;

    private String title;
    private String content;

    // Entity는 기본생성자가 있어야 함

    // 비즈니스 로직에 가까운 setter
    public PostJpaV2 update(String title, String content){
        this.title = title;
        this.content = content;

        return this;
    }

}
