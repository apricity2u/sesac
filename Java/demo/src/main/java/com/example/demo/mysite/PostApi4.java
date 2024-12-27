package com.example.demo.mysite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v4/posts")
public class PostApi4 {

    // Post class의 instance, 즉 게시글을 넣을 list 생성
    private List<Post> posts = new ArrayList<>();
    private Long id = 0L; // 게시글 생성에서 id 생성을 위한 장치

    {
        // 인스턴스가 생성되었을 때 한 번 실행된다.
        // 초기값을 넣을 때 사용된다.
        posts.add(new Post(++id, "초기 제목", "초기 내용"));
    }


    // create
    // post / 내용 / url
    // restful
    // "/posts" / method : POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost){
        // title = 입력받은 title
        // content = 입력받은 content

        String title = newPost.getTitle();
        String content = newPost.getContent();

        if (title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요.");
        }

        if (content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요.");
        }

        Post post = new Post(++id, title, content);
        posts.add(post);

        return post;
    }

    // read
    // posts / get
    @GetMapping
    public List<Post> readPosts(){
        return posts;
    }

    // read - 단일 조회
    // { } : react ':id' 동적라우팅처럼 변수로 사용하겠다는 약속
    // @PathVariable : 경로에서 사용하는 변수
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id){
        // posts에서 post를 가져오자.
        for (Post post : posts) {
            if (post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    // update
    // 변경 내용 / id / url
    // restful
    // "/posts/{id}" / method : PUT, PATCH
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost){

        String title = updatedPost.getTitle();
        String content = updatedPost.getContent();

        if (title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요.");
        }

        if (content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요.");
        }

        for (Post post : posts) {
            if (post.getId().equals(id)){
                post.setTitle(title);
                post.setContent(content);
                return post;
            }
        }
        return null;
    }

    // delete
    // restful
    // "/posts/{id}" / method : DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post deletePost(@PathVariable Long id){
        Post removedPost = null;
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                removedPost = post;
                break;
            }
        }
        posts.remove(removedPost);
        return null;
    }

    @GetMapping("/paged")
    public List<Post> getPagedPosts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){

        // 1. 페이지네이션을 위한 더미데이터 추가
        for (int i = 1; i <= 20; i++) {
            String title = "제목 " + i;
            String content = "내용 " + i;
            Post post = new Post(++id, title, content);
            posts.add(post);
        }

        // 2. 시작 인덱스와 끝 인덱스 계산
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, posts.size());

        // 3. 페이지에 해당하는 데이터만 추출
        return posts.subList(startIndex, endIndex);
    }

}
