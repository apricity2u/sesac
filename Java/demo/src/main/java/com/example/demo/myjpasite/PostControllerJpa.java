package com.example.demo.myjpasite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/posts")
public class PostControllerJpa {

    private final PostServiceJpa postServiceJpa;

    public PostControllerJpa(PostServiceJpa postServiceJpa) {
        this.postServiceJpa = postServiceJpa;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpa createPost(@RequestBody PostJpa newPost){
        return postServiceJpa.createPosts(newPost);
    }

    @GetMapping
    public List<PostJpa> getPosts(){
        return postServiceJpa.getPosts();
    }

    @GetMapping("/{id}")
    public PostJpa getPostById(@PathVariable Long id){
        return postServiceJpa.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpa updatePost(@PathVariable Long id, @RequestBody PostJpa updatedPost){
        return postServiceJpa.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postServiceJpa.deletePost(id);
    }

}
