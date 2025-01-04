package com.example.demo.myjpasite4;

import com.example.demo.myjpasite4.dto.PostCreateRequestDto;
import com.example.demo.myjpasite4.dto.PostListResponseDto;
import com.example.demo.myjpasite4.dto.PostResponseDto;
import com.example.demo.myjpasite4.dto.PostUpdateRequestDto;
import com.example.demo.myjpasite4.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor // PostService가 필요하니까 생성자가 필요함
public class PostControllerV4 {

    private final PostServiceV4 postServiceV4;

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ApiResponse.error("resoure not found", "NOT_FOUND"));
//                // .body(ApiResponse.error(ex.getMessage(), "NOT_FOUND"));
//    }

    //Post method / url / data
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        "게시글이 정상적으로 작성되었습니다.",
                        "CREATED",
                        postServiceV4.createPost(requestDto)
                    )
                );
    }

    // Get method / url / 전체
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts(){
        // 데이터 가져와
        List<PostListResponseDto> data = postServiceV4.readPosts();
        // code, message를 추가하기
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(data);

        return ResponseEntity.ok(response);
    }

    // Get method / url / id / 단일
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.readPostById(id)));
    }

    // Put method / url / id / 수정사항
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.updatePost(id, requestDto)));
    }

    //
//    // Delete method / url / id
//    @DeleteMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> deletePost(@PathVariable Long id){
//        postServiceV4.deletePost(id);
//        return ResponseEntity.noContent().build();
//    }


    // 200 메세지를 보여주고, 정상적으로 삭제되었다고 알려주기
    // Delete method / url / id
    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id){
        postServiceV4.deletePost(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다.",
                        "DELETED",
                        null
                )
        );
    }

}
