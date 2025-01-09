package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.BaseTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
}
