package com.example.practice.mysite.dto;

import com.example.practice.mysite.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    @NotBlank
    @Length(min=3, max=20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min=2, max=10)
    private String nickname;

    @Size(min=0, max=150)
    private Integer age;

    public User toEntity(){
        return User.builder()
                .username(this.getUsername())
                .email(this.getEmail())
                .nickname(this.getNickname())
                .age(this.getAge())
                .build();
    }

}
