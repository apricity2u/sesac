package com.example.relation.domain.example;

import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.domain.post.dto.PostWithCommentResponseDtoV2;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final PostRepository postRepository;

    @GetMapping("/basic/{postId}")
    public void LoadingExample1(@PathVariable Long postId){
        Post post = postRepository.findById(postId).orElseThrow(); // 첫번째 쿼리 요청
        int commentSize = post.getComments().size(); // 두번째 쿼리 요청

        // 이 경우 lazy여도 쿼리가 한 번만 요청
        // 데이터를 아직 사용하지 않은 상태이기 때문 ( join을 안했음 )
        // List<Comment> comments = post.getComments(); 이게 바로 프록시 객체
        // size는 그 안에 있는 데이터를 알아야 해서 쿼리가 두 번 날라가는 것
    }

    @GetMapping("/fetch/{postId}")
    public void LoadingExample2(@PathVariable Long postId){
        Post post = postRepository.findByIdWithCommentFetch(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    @GetMapping("/nplus1/basic")
    public void LoadingExample3(){
        List<Post> posts = postRepository.findAll();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

    @GetMapping("/nplus1/fetch")
    public void LoadingExample4(){
        List<Post> posts = postRepository.findAllWithCommentFetch();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

    @GetMapping("/nplus1/entity-graph")
    public void LoadingExample5(){
        List<Post> posts  =postRepository.findAllWithCommentEntityGraph();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

//    @GetMapping("/orphan/{postId}")
//    @Transactional
//    public void orphan(@PathVariable Long postId) {
//
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new ResourceNotFoundException());
//
//        post.getComments().remove(0); // Dirty checking으로 인해 참조가 사라진
//
//    }

}
