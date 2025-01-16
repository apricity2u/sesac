package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.responsedto.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.service.UserService;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/my/profile")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile(){

        // controller의 역할은? 요청을 받아서 service한테 넘겨준다.

        // 요청 시에는 url, method, data, headers가 온다.
        // 지금은 headers 안에 있는 JWT를 통해 데이터를 받았다.

        // 이렇게 request에서 가져온 데이터에 대한 처리는 controller에서 하자.

        // 인증 객체를 빼오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(ApiResponse.ok(userService.getMyProfile(user)));
    }

    @GetMapping("/my/profile2")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile2(
            @AuthenticationPrincipal User user
    ){
        return ResponseEntity.ok(ApiResponse.ok(userService.getMyProfile(user)));
    }
}
