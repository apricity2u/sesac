package com.example.practice.mysite;

import com.example.practice.mysite.dto.UserCreateRequestDto;
import com.example.practice.mysite.dto.UserListResponseDto;
import com.example.practice.mysite.dto.UserResponseDto;
import com.example.practice.mysite.dto.UserUpdateRequestDto;
import com.example.practice.mysite.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    // 1. Create
    @Transactional
    public UserResponseDto createUser(UserCreateRequestDto newUser){
        User user = userRepository.save(newUser.toEntity());
        return UserResponseDto.from(user);
    }

    // 2. Read
    // 전체 조회
    public List<UserListResponseDto> getUsers(){
        return userRepository.findAll().stream()
                .map(UserListResponseDto::from)
                .toList();
    }

    // 단일 조회
    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("없는 id 값입니다."));
        return UserResponseDto.from(user);
    }

    // 3. Update
    @Transactional
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto updatedUser){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("없는 id 값입니다."));

        user.update(updatedUser);
        return UserResponseDto.from(user);
    }

    // 4. Delete
    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("없는 id 값입니다."));

        userRepository.delete(user);
    }

}
