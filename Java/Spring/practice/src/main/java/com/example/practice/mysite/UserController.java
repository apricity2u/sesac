package com.example.practice.mysite;

import com.example.practice.mysite.dto.UserCreateRequestDto;
import com.example.practice.mysite.dto.UserListResponseDto;
import com.example.practice.mysite.dto.UserResponseDto;
import com.example.practice.mysite.dto.UserUpdateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@Valid @RequestBody UserCreateRequestDto newUser){
        return userService.createUser(newUser);
    }

    // 2. Read
    // 전체조회 : url / method(GET)
    @GetMapping
    public List<UserListResponseDto> getUsers(){
        return userService.getUsers();
    }

    // 단일조회 : url / method(GET) / id
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    // 3. Update
    // url / method(PUT) / id / 변경할 내용
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto updatedUser){
        return userService.updateUser(id, updatedUser);
    }

    // 4. Delete
    // url / method(DELETE) / id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
