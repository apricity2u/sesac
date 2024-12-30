package com.example.demo.mysite.postMVC;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Service;

import java.util.List;

// 서비스임을 명시함
@Service
public class PostService {

//    // post를 생성하려면 repository의 save를 가져와야 함.
//    PostRepository postRepository = new PostRepository();

    // DI
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // controller에게 데이터를 입력 받아서
    public Post createPost(Post newPost){

        // validation 체크를 한 후에 -> 비즈니스 로직 처리. 내가 할 것 할게.
        validatePostData(newPost);

        // post를 생성하겠다.
        return postRepository.save(newPost);

        // 컨트롤러에게서 데이터를 입력받아서, 비즈니스 로직 구현
    }

    public List<Post> readPosts(){
        return postRepository.findAll();
    }

    public Post readPostById(Long id){

        Post post = postRepository.findPostById(id);

        checkPostIsNull(post);

        return post;
    }

    // 수정 : findbyid를 해서 save를 해야함
    public Post updatePost(Long id, Post updatedPost){

        // 일단 findByID로 게시글이 있는지 찾기
        Post post = postRepository.findPostById(id);

        // 게시물이 있는지 체크
        checkPostIsNull(post);

        // 수정할 데이터가 있는지 체크
        validatePostData(updatedPost);

        return postRepository.modify(id, updatedPost);
    }

    public void checkPostIsNull(Post post){
        if (post == null){
            throw new IllegalArgumentException("없는 id입니다");
        }
    }

    public void validatePostData(Post post){

        String title = post.getTitle();
        String content = post.getContent();

        if (title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요.");
        }

        if (content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요.");        }

    }

    public void deletePost(Long id){

        Post post = postRepository.findPostById(id);

        // 게시글이 없으면 삭제할 필요도 없으니까
        checkPostIsNull(post);

        postRepository.delete(post);
    }

}
