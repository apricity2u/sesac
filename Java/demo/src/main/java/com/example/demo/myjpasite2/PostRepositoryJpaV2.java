package com.example.demo.myjpasite2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV2 {

    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            em.persist(post);
            tx.commit();
            return post;

        } catch (Exception e) {

            tx.rollback();
            throw e;

        } finally {

            em.close();

        }
    }

    public PostJpaV2 findById(Long id){

        EntityManager em = emf.createEntityManager();

        try{
            return em.find(PostJpaV2.class, id);
        }finally {
            em.close();
        }
    }

    public List<PostJpaV2> findAll() {
        EntityManager em = emf.createEntityManager();
        // post에서 모든 데이터를 가져오고 싶어.
        // Select * FROM POSTS P

        // TABLE을 ENTITY로 교체하는 JPQL
        // 하고 싶은 쿼리 동작이 있으면 검색해보기!
        try{
            return em.createQuery("SELECT p FROM PostJpaV2 p", PostJpaV2.class)
                    .getResultList();
        }finally {
            em.close();
        }
    }

    public PostJpaV2 update(Long id, PostJpaV2 updatedPost){

        // 우리가 가진 정보들을 관리함 => 영속
        // 그냥 Post를 생성하면 메모리에 넣은 것
        // 하지만 persist, find 등을 통해서 관리를 하면, em의 관리를 받는 것
        // 만약에 값이 바뀌면, commit이 되었을 때 DB에 저장을 할 수 있음 (이것이 바로 Dirty Checking)
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            // 업데이트할 entity를 가져와서
            PostJpaV2 post = em.find(PostJpaV2.class, id);

            String title = updatedPost.getTitle();
            String content = updatedPost.getContent();

            // 수정한다
            post.update(title, content);
            // 커밋 시점에 자동으로 수정사항 반영됨
            tx.commit();
            return post;
        }catch (Exception e){
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }

    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PostJpaV2 post = em.find(PostJpaV2.class, id);
            em.remove(post);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}
