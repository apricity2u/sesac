package com.example.demo.myjpasite;

import com.example.demo.mysite.Post;
import com.example.demo.mysite.postMVC.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpa {

    private final PostRepositoryJpa postRepositoryJpa;

    public PostServiceJpa(PostRepositoryJpa postRepositoryJpa) {
        this.postRepositoryJpa = postRepositoryJpa;
    }

    public PostJpa createPosts(PostJpa post){
        return postRepositoryJpa.save(post);
    }

    public List<PostJpa> getPosts(){
        return postRepositoryJpa.findAll();
    }

    public PostJpa getPostById(Long id){
        // Post 거나 에러를 나거나 => 그래서 return 타입이 PostJpa
        return postRepositoryJpa.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("없는 Post 입니다."));
    }

    public PostJpa updatePost(Long id, PostJpa updatePost){
        // 수정할 Post를 찾아야 함
        PostJpa post = postRepositoryJpa.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("없는 POST 입니다"));

        String title = updatePost.getTitle();
        String content = updatePost.getContent();

        post.update(title, content);
        return postRepositoryJpa.save(post);

        // return postRepositoryJpa.save(post.update(title, content));
    }

    public void deletePost(Long id){
        PostJpa post = postRepositoryJpa.findById(id)
                .orElseThrow(()->new IllegalArgumentException("없는 POST입니다."));
        postRepositoryJpa.delete(post);
    }

}
