package com.example.practice.mysite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class UserUpdateRequestDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min=2, max=10)
    private String nickname;

    @Size(min=0, max=150)
    private Integer age;

    private Boolean isActive;

}
