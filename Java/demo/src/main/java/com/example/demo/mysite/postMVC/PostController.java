package com.example.demo.mysite.postMVC;

import com.example.demo.mysite.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc/posts")
public class PostController {

//    PostService postService = new PostService();

    // DI
    // 난 PostService를 사용할거야
    PostService postService;

    // 넌 이제 bean 자리야
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        // newPost를 json 형태로 변경해서
        // post를 생성

        // 요청을 받아서 Service에 맡김. 그리고 Service가 내뱉은 결과물을 반환함
        return postService.createPost(newPost);

    }

    @GetMapping
    public List<Post> readPosts(){
        return postService.readPosts();
    }

    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id){
        return postService.readPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost){
        return postService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
