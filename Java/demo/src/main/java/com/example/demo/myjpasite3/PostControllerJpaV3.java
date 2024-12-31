package com.example.demo.myjpasite3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpaV3/posts")
public class PostControllerJpaV3 {

    private final PostServiceJpaV3 postServiceJpaV3;

    public PostControllerJpaV3(PostServiceJpaV3 postServiceJpaV3) {
        this.postServiceJpaV3 = postServiceJpaV3;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpaV3 createPost(@RequestBody PostJpaV3 newPost){
        return postServiceJpaV3.createPost(newPost);
    }

    @GetMapping
    public List<PostJpaV3> getPosts(){
        return postServiceJpaV3.getPosts();
    }

    @GetMapping("/{id}")
    public PostJpaV3 getPostById(@PathVariable Long id){
        return postServiceJpaV3.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 updatedPost){
        return postServiceJpaV3.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postServiceJpaV3.deletePost(id);
    }

}
