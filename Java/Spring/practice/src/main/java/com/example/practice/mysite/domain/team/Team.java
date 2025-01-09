package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.BaseTimeEntity;
import com.example.practice.mysite.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<User> userList;

    @Builder
    public Team(String teamName) {
        this.teamName = teamName;
    }
}
