package com.example.demo.myjpasite3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceJpaV3 {
    private final PostRepositoryJpaV3 postRepositoryJpaV3;

    @Transactional
    public PostJpaV3 createPost(PostJpaV3 post){
        return postRepositoryJpaV3.save(post);
    }

    // read는 Transactional 필요없음
    public List<PostJpaV3> getPosts(){
        return postRepositoryJpaV3.findAll();
    }

    public PostJpaV3 getPostById(Long id){
        return postRepositoryJpaV3.findById(id);
    }

    @Transactional
    public PostJpaV3 updatePost(Long id, PostJpaV3 updatedPost){
        return postRepositoryJpaV3.update(id, updatedPost);
    }

    @Transactional
    public void deletePost(Long id){
        postRepositoryJpaV3.delete(id);
    }
}
