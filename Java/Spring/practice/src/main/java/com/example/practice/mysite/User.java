package com.example.practice.mysite;

import com.example.practice.mysite.dto.UserUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String nickname;
    private Integer age;
    private Boolean isActive;

    @Builder
    public User(String username, String email, String nickname, Integer age) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.isActive = true;
    }

    public User update(UserUpdateRequestDto updatedUser){
        this.nickname = updatedUser.getNickname();
        this.email = updatedUser.getEmail();
        return this;
    }


}
