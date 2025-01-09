package com.example.relation.domain.post;

import jakarta.persistence.Entity;
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
}
