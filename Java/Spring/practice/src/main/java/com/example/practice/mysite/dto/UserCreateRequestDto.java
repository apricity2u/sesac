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
    @Length(min=3, max=20, message = "이름은 3글자 이상 20글자 이하여야 합니다.")
    private String username;

    @NotBlank
    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @NotBlank
    @Length(min=2, max=10, message = "닉네임은 2글자 이상 10글자 이하여야 합니다.")
    private String nickname;

    @Size(min=0, max=150, message = "나이는 최대 150살까지만 입력 가능합니다.")
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
