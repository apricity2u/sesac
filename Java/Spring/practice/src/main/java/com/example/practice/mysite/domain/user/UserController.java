package com.example.practice.mysite.domain.user;

import com.example.practice.mysite.global.ApiResponse;
import com.example.practice.mysite.domain.user.dto.UserCreateRequestDto;
import com.example.practice.mysite.domain.user.dto.UserListResponseDto;
import com.example.practice.mysite.domain.user.dto.UserResponseDto;
import com.example.practice.mysite.domain.user.dto.UserUpdateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. Create
    // url / method(POST) / 새로운 유저 정보
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@PathVariable Long teamId, @Valid @RequestBody UserCreateRequestDto newUser){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        "유저 정보가 성공적으로 저장되었습니다.",
                        "CREATED",
                        userService.createUser(teamId, newUser)
                ));
    }

    // 2. Read
    // 전체조회 : url / method(GET)
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUsers(){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUsers()));
    }

    // 단일조회 : url / method(GET) / id
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Long teamId, @PathVariable Long userId){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserById(teamId, userId)));
    }

    // 3. Update
    // url / method(PUT) / id / 변경할 내용
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto updatedUser){
        return ResponseEntity
                .ok(ApiResponse.ok(
                        "유저 정보가 성공적으로 수정되었습니다.",
                        "UPDATED",
                        userService.updateUser(id, updatedUser)
                ));
    }

    // 4. Delete
    // url / method(DELETE) / id
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok(ApiResponse.ok(
                        "유저 정보가 성공적으로 삭제되었습니다.",
                        "DELETED",
                        null
                ));
    }

    // [ 추가 API ]

    // 특정 닉네임을 가진 사용자 조회
    @GetMapping("/nickname")
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUserByNickname(@RequestParam String nickname){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserByNickname(nickname)));
    }

    // 특정 나이의 사용자 조회
    @GetMapping("/age")
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUserByAge(@RequestParam Integer age){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserByAge(age)));
    }

    // 활성화된 사용자 조회
    @GetMapping("/isActive")
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUserByIsActive(@RequestParam Boolean isActive){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserByIsActive(isActive)));
    }

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    @GetMapping("/email")
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUserByEmailDomain(@RequestParam String emailDomain){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserByEmailDomain(emailDomain)));
    }

    // 특정 나이의 사용자 조회
    @GetMapping("/greaterThanAge")
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUserByGreaterThanAge(@RequestParam Integer age){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserByGreaterThanAge(age)));
    }


}
