package com.example.demo.myjpasite;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository는 테이블과 연결되어 제네릭 사용할 것
// @Repository 안 써도 bean으로 관리됨
public interface PostRepositoryJpa extends JpaRepository<PostJpa, Long> {
// 여기까지만 하면 자동으로 CRUD 생성됨

}
