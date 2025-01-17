package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.requestdto.LoginRequestDto;
import com.example.relation.domain.user.dto.requestdto.SignupRequestDto;
import com.example.relation.domain.user.dto.responsedto.SignupResponseDto;
import com.example.relation.domain.user.dto.responsedto.TokenResponseDto;
import com.example.relation.domain.user.service.AuthService;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(@Valid @RequestBody SignupRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(authService.signup(requestDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto){
        return ResponseEntity.ok(ApiResponse.ok(authService.login(requestDto)));
    }

    @GetMapping("/verify")
    public void verify(){}

}
