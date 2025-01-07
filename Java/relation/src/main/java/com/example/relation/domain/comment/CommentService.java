package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto requestDto){
        // 1.  게시글을 먼저 찾는다
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("게시글이 존재하지 않습니다."));
        // 2. DB와 소통하기 위해 RequestDto를 Entity로 변경한다.
        Comment comment = requestDto.toEntity(post);
        return CommentResponseDto.from(commentRepository.save(comment));
    }

}
