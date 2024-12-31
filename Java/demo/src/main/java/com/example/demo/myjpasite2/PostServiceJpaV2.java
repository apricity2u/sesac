package com.example.demo.myjpasite2;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpaV2 {

    private final PostRepositoryJpaV2 postRepositoryV2;

    public PostServiceJpaV2(PostRepositoryJpaV2 postRepositoryV2) {
        this.postRepositoryV2 = postRepositoryV2;
    }

    public PostJpaV2 createPosts(PostJpaV2 post){
        return postRepositoryV2.save(post);
    }

    public List<PostJpaV2> getPosts(){
        return postRepositoryV2.findAll();
    }

    public PostJpaV2 getPostById(Long id){
        // Post 거나 에러를 나거나 => 그래서 return 타입이 PostJpa
        return postRepositoryV2.findById(id);
    }

    public PostJpaV2 updatePost(Long id, PostJpaV2 updatePost){
        return postRepositoryV2.update(id, updatePost);
    }

    public void deletePost(Long id){
        postRepositoryV2.delete(id);
    }

}
