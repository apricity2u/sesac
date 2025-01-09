package com.example.relation.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // post id에 해당하는 comments를 찾는다
    public List<Comment> findByPostId(Long postId);

}