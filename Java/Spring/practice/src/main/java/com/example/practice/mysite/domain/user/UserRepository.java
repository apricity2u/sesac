package com.example.practice.mysite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    // [ JPQL ]
//    // 특정 닉네임을 가진 사용자 조회
//    @Query("SELECT u FROM User u WHERE u.nickname = :nickname")
//    List<User> findByNickname(@Param("nickname") String nickname);
//
//    // 특정 나이의 사용자 조회
//    @Query("SELECT u FROM User u WHERE u.age = :age")
//    List<User> findByAge(@Param("age") Integer age);
//
//    // 활성화된 사용자 조회
//    @Query("SELECT u FROM User u WHERE u.isActive = :isActive")
//    List<User> findByIsActive(@Param("isActive") Boolean isActive);
//
//    // 이메일이 특정 도메인으로 끝나는 사용자 조회
//    @Query("SELECT u FROM User u WHERE u.email LIKE %:emailDomain%")
//    List<User> findByEmailDomain(@Param("emailDomain") String emailDomain);


    // [ Query Method ]
    // 특정 닉네임을 가진 사용자 조회
    List<User> findByNickname(String nickname);

    // 특정 나이의 사용자 조회
    List<User> findByAge(Integer age);

    // 활성화된 사용자 조회
    List<User> findByIsActive(Boolean isActive);

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    List<User> findByEmailContaining(String emailDomain);

    // 특정 나이 이후 사용자 조회
    List<User> findByAgeGreaterThan(Integer age);

}
