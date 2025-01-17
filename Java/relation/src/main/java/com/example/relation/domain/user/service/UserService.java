package com.example.relation.domain.user.service;

import com.example.relation.domain.post.dto.Post2ListPageResponseDto;
import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.responsedto.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Post2Repository post2Repository;

    public UserResponseDto getMyProfile(User user){
        // 이미 유저에 대한 정보가 있기 때문에 repository가 필요없음
        return UserResponseDto.from(user);
    }

    public Post2ListPageResponseDto getMyPosts(User user, Pageable pageable){
        return Post2ListPageResponseDto.from(post2Repository.findAllByAuthorId(user.getId(), pageable));
    }

}
