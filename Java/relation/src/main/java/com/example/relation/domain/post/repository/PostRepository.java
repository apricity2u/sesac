package com.example.relation.domain.post.repository;

import com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p LEFT JOIN p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithComment(@Param("id") Long id);

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithCommentFetch(@Param("id") Long id);

    @Query("SELECT p FROM Post p LEFT JOIN FETCH  p.comments")
    List<Post> findAllWithCommentFetch();

    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p")
    List<Post> findAllWithCommentEntityGraph();

    @Query("SELECT p, Count(c) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<Object[]> findAllWithCommentCount();

    @Query("SELECT new com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto(p.id, p.title, p.createdAt, COUNT(c)) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<PostListWithCommentCountResponseDto> findAllWithCommentCountDTO();

    @Query("SELECT p FROM Post p " +
            "LEFT JOIN p.comments c " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdwithCommentAndTag(@Param("id") Long id);

    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithTag(@Param("id") Long id);

    // 태그 별 게시글 조회
    @Query("""
            SELECT p FROM Post p
            JOIN p.postTags pt
            JOIN pt.tag t
            WHERE t.name = :tagName
            """)
    List<Post> findAllByTagName(@Param("tagName") String tagName);

}