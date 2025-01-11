package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts(){
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostWithCommentResponseDto readPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentResponseDto.from(post, comments);
    }

    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id){
        // post, comment를 한 번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id).orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentResponseDtoV2.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        postRepository.delete(post);
    }

    public List<PostListWithCommentCountResponseDto> readPostswithCommentCount(){
        List<Object[]> results = postRepository.findAllWithCommentCount();
        return results.stream()
                .map(result -> {
                    Post post = (Post) result[0];
                    Long commentCount = (Long) result[1];
                    return new PostListWithCommentCountResponseDto(
                            post.getId(),
                            post.getTitle(),
                            post.getCreatedAt(),
                            commentCount
                    );
                })
                .toList();
    }

    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCountDto(){
        return postRepository.findAllWithCommentCountDTO();
    }

    @Transactional
    public void addTagToPost(Long id, TagRequestDto requestDto){

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

//        Tag tag = tagRepository.findByName(requestDto.getName())
//                .orElseThrow(() -> new ResourceNotFoundException());

        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseGet(() -> {
                    // 없는 태그라면 태그를 post하기
                    Tag newTag = new Tag(requestDto.getName());
                    return tagRepository.save(newTag);
                });

        if (postTagRepository.existsByPostAndTag(post, tag)) {
            throw new DuplicateEntityException();
        }

        PostTag postTag = new PostTag();
        postTag.addPost(post);
        postTag.addTag(tag);

        // 양방향 연관관계
        post.getPostTags().add(postTag);

        postTagRepository.save(postTag);
    }

    public PostWithCommentAndTagResponseDto readPostsByIdWithCommentAndTag(Long id){

        //
        // Post post = postRepository.findByIdwithCommentAndTag(id)
        //               .orElseThrow(() -> new ResourceNotFoundException());

        Post postWithTag = postRepository.findByIdWithTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentAndTagResponseDto.from(postWithTag, comments);
    }

    public PostWithCommentAndTagResponseDtoV2 readPostByIdWithCommentAndTagV2(Long id){
        Post post = postRepository.findByIdwithCommentAndTag(id)
        .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentAndTagResponseDtoV2.from(post);
    }

    public List<PostWithCommentAndTagResponseDtoV2> readPostsByTag(String tag){

        return postRepository.findAllByTagName(tag).stream()
                .map(PostWithCommentAndTagResponseDtoV2 :: from)
                .toList();

    }

}