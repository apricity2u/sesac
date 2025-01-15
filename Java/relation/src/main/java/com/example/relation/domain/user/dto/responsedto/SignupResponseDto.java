package com.example.relation.domain.user.dto.responsedto;

import com.example.relation.domain.user.entity.Role;
import com.example.relation.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDto {

    // id는 username이라는 유니크 값이 있어서 필요없음

    private String username;
    private String email;
    private Role role;

    public static SignupResponseDto from(User entity){
        return SignupResponseDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }
}

