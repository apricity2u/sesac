package com.example.practice.mysite;

import com.example.practice.mysite.dto.UserCreateRequestDto;
import com.example.practice.mysite.dto.UserListResponseDto;
import com.example.practice.mysite.dto.UserResponseDto;
import com.example.practice.mysite.dto.UserUpdateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. Create
    // url / method(POST) / 새로운 유저 정보
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserCreateRequestDto newUser){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        "유저 정보가 성공적으로 저장되었습니다.",
                        "CREATED",
                        userService.createUser(newUser)
                ));
    }

    // 2. Read
    // 전체조회 : url / method(GET)
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> getUsers(){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUsers()));
    }

    // 단일조회 : url / method(GET) / id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.ok(userService.getUserById(id)));
    }

    // 3. Update
    // url / method(PUT) / id / 변경할 내용
    @PutMapping("/{id}")
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
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok(ApiResponse.ok(
                        "유저 정보가 성공적으로 삭제되었습니다.",
                        "DELETED",
                        null
                ));
    }

    // 추가 API

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

//
//    @GetMapping("/search")
//    public type getUserByDetail(
//            @RequestParam(required = false) String nickname,
//            @RequestParam(required = false) Integer age,
//            @RequestParam(required = false) Boolean isActive
//    ){
//        return userService.getUserByDetail(nickname, age, isActive);
//    }


}
