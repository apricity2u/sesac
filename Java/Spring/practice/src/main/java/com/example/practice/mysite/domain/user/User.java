package com.example.practice.mysite.domain.user;

import com.example.practice.mysite.BaseTimeEntity;
import com.example.practice.mysite.domain.team.Team;
import com.example.practice.mysite.domain.user.dto.UserUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

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

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public User(String username, String email, String nickname, Integer age, Team team) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.team = team;
        this.isActive = true;
    }

    public User update(UserUpdateRequestDto updatedUser){
        this.nickname = updatedUser.getNickname();
        this.email = updatedUser.getEmail();
        this.isActive = updatedUser.getIsActive();
        this.age = updatedUser.getAge();
        return this;
    }


}
