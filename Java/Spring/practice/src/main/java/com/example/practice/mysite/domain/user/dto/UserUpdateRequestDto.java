package com.example.practice.mysite.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter
public class UserUpdateRequestDto {

    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @Length(min=2, max=10, message = "닉네임은 2글자 이상 10글자 이하여야 합니다.")
    private String nickname;

    @Range(min=0, max=150, message = "나이는 최대 150살까지만 입력 가능합니다.")
    private Integer age;

    private Boolean isActive;

}
