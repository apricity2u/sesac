package com.example.demo.mysite.postMVC;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    // Repository는 DB와 상호작용함
    // DB 역할
    private List<Post> posts = new ArrayList<>();
    private Long id = 0L; // 게시글 생성에서 id 생성을 위한 장치

    // 저장. create 그 자체
    public Post save(Post newPost){

        String title = newPost.getTitle();
        String content = newPost.getContent();

        Post post = new Post(++id, title, content);
        posts.add(post);

        return post;
    }

    // 모든 게시글을 가져온다.
    public List<Post> findAll(){
        return posts;
    }

    // 선택한 게시글을 가져온다.
    public Post findPostById(Long id){
        for (Post post : posts) {
            if (post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    // 게시글을 업데이트 한다.
    public Post modify(Long id, Post updatedPost){

        String title = updatedPost.getTitle();
        String content = updatedPost.getContent();

        for (Post post : posts) {
            if (post.getId().equals(id)){
                post.setTitle(title);
                post.setContent(content);
                return post;
            }
        }
        return null;
    }

    public void delete(Post post){
        posts.remove(post);
    }

}
