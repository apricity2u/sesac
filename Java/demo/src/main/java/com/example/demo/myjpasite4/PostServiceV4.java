package com.example.demo.myjpasite4;

import com.example.demo.myjpasite4.dto.PostCreateRequestDto;
import com.example.demo.myjpasite4.dto.PostListResponseDto;
import com.example.demo.myjpasite4.dto.PostResponseDto;
import com.example.demo.myjpasite4.dto.PostUpdateRequestDto;
import com.example.demo.myjpasite4.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV4 {

    private final PostRepositoryV4 postRepositoryV4;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto){

        // RequestDTO => Post (Entity)
        // PostV4 transientPost = requestDto.toEntity();
        // PostV4 managedPost = postRepositoryV4.save(transientPost);

        PostV4 post = postRepositoryV4.save(requestDto.toEntity());
        return PostResponseDto.from(post);
        // return new PostResponseDto(post.getId(), post,getTitle(), post.getContent(), post.getAuthor());
    }

    public List<PostListResponseDto> readPosts(){

        // 리스트의 결과를 모두 DTO로 바꿔야함 (x -> f(x)로 변환하는 과정 : map)
        // map을 사용하기 위해서는 stream을 써야함
        // map으로 DTO로 바꾸고 toList로 리스트로 만들기
        return postRepositoryV4.findAll().stream()
                .map(PostListResponseDto :: from)
                .toList();
                // .map((post) -> PostResponseDto.from(post))
    }

    public PostResponseDto readPostById(Long id){
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException());
        return PostResponseDto.from(post);
    }

    // 수정에 대한 transactional => Dirty Checking
    // 하나의 논리적인 행위를 묶어서 사용
    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);
        // Transactional : Dirty Checking이 되기 때문에 따로 저장하지 않아도 됨
        // postRepositoryV4.save(post);
        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id){
        // 하나 가져오자 => 삭제하자
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 id입니다."));

        postRepositoryV4.delete(post);
    }

}
