package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.responsedto.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto getMyProfile(User user){
        // 이미 유저에 대한 정보가 있기 때문에 repository가 필요없음
        return UserResponseDto.from(user);
    }

}
