package com.example.practice.mysite.domain.user;

import com.example.practice.mysite.domain.team.Team;
import com.example.practice.mysite.domain.team.TeamRepository;
import com.example.practice.mysite.domain.user.dto.UserCreateRequestDto;
import com.example.practice.mysite.domain.user.dto.UserListResponseDto;
import com.example.practice.mysite.domain.user.dto.UserResponseDto;
import com.example.practice.mysite.domain.user.dto.UserUpdateRequestDto;
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
    private final TeamRepository teamRepository;

    // 1. Create
    @Transactional
    public UserResponseDto createUser(Long teamId, UserCreateRequestDto newUser){
        // 중복 불가를 Service에서도 한 번 처리해보자

        Team team = teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFoundException());
        User user = userRepository.save(newUser.toEntity(team));
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
    public UserResponseDto getUserById(Long teamId, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("없는 유저입니다."));

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

    // 추가 API
    // 특정 닉네임을 가진 사용자 조회
    public List<UserListResponseDto> getUserByNickname(String nickname){
        return userRepository.findByNickname(nickname).stream()
                .map(UserListResponseDto :: from)
                .toList();
    }

    // 특정 나이를 가진 사용자 조회
    public List<UserListResponseDto> getUserByAge(Integer age){
        return userRepository.findByAge(age).stream()
                .map(UserListResponseDto :: from)
                .toList();
    }

    // 활성화된 사용자 조회
    public List<UserListResponseDto> getUserByIsActive(Boolean isActive){
        return userRepository.findByIsActive(isActive).stream()
                .map(UserListResponseDto :: from)
                .toList();
    }

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    public List<UserListResponseDto> getUserByEmailDomain(String emailDomain){
//        return userRepository.findByEmailDomain(emailDomain).stream()
//                .map(UserListResponseDto :: from)
//                .toList();

        return userRepository.findByEmailContaining(emailDomain).stream()
                .map(UserListResponseDto :: from)
                .toList();

    }

    // 특정 나이 이후의 비활성 사용자 조회
    public List<UserListResponseDto> getUserByGreaterThanAge(Integer age){
        return userRepository.findByAgeGreaterThan(age).stream()
                .filter(User::getIsActive)
                .map(UserListResponseDto :: from)
                .toList();
    }

}
