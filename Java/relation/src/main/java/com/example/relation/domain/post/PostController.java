package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "게시글 관리", description = "게시글 관리 API")
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @Operation(
            summary = "게시글 작성",
            description = """
            제목, 내용을 입력받아 게시글을 작성한다.
        """
    )
    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다","CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDto>> readPostById(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDto> response = ApiResponse.ok(postService.readPostById(id));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDtoV2> response = ApiResponse.ok(postService.readPostByIdV2(id));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/comment-count")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostswithCommentCount(){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostswithCommentCount()
        ));
    }

    @GetMapping("/comment-count-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCountDto() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentCountDto()
                )
        );
    }

    // post와 tag를 가지고 연결시켜주기
    @PostMapping("/{id}/tags")
    public void addTagToPost(@PathVariable Long id, @Valid @RequestBody TagRequestDto requestDto){
        postService.addTagToPost(id, requestDto);
    }

    // 게시글을 댓글과 태그들과 함께 조회
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostsByIdWithCommentAndTag(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.ok(postService.readPostsByIdWithCommentAndTag(id)));

    }

    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostByIdWithCommentAndTagV2(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.ok(postService.readPostByIdWithCommentAndTagV2(id)));

    }

    // Tag별 게시글 가져오기
    @GetMapping("/tags")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsByTag(@RequestParam String tag){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsByTag(tag)
        ));
    }

    @GetMapping("/pages")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsWithPage(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(postService.readPostsWithPage(pageable)));
    }

    @GetMapping("/pages/detail")
    public ResponseEntity<ApiResponse<PostListWithPageResponseDto>> readPostWithPageDetail(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(postService.readPostWithPageDetail(pageable)));
    }

    @GetMapping("/detail/pages")
    public ResponseEntity<ApiResponse<List<PostWithCommentResponseDtoV2>>> readPostWithCommentPage(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(postService.readPostWithCommentPage(pageable)));
    }

    @PostMapping("/images")
    public ResponseEntity<ApiResponse<PostWithImageResponseDto>> createPostWithImage(
            @RequestPart(value = "data") PostCreateRequestDto requestDto,
            @RequestPart(value = "image", required = false) MultipartFile image
            // 이미지가 없어도 게시글 생성 가능
            // 이미지를 여러 개 등록 가능하기 때문에 List<MultipartFile> 로 받아도 됨
    ){
        return ResponseEntity.ok(ApiResponse.ok(postService.createPostWithImage(requestDto, image)));
    }

    @PostMapping("/post2")
    public ResponseEntity<ApiResponse<Post2ResponseDto>> createPost2(
            @RequestBody Post2CreateWithAuthorRequestDto requestDto,
            @AuthenticationPrincipal User user
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(ApiResponse.ok(
                                "게시글이 정상적으로 생성되었습니다.",
                                "CREATED",
                                postService.createPost2(requestDto, user)
                        ));
    }

}





