package com.example.demo.myjpasite2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpaV2/posts")
public class PostControllerJpaV2 {

    private final PostServiceJpaV2 postServiceV2;

    public PostControllerJpaV2(PostServiceJpaV2 postServiceV2) {
        this.postServiceV2 = postServiceV2;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpaV2 createPost(@RequestBody PostJpaV2 newPost){
        return postServiceV2.createPosts(newPost);
    }

    @GetMapping
    public List<PostJpaV2> getPosts(){
        return postServiceV2.getPosts();
    }

    @GetMapping("/{id}")
    public PostJpaV2 getPostById(@PathVariable Long id){
        return postServiceV2.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 updatedPost){
        return postServiceV2.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postServiceV2.deletePost(id);
    }

}
