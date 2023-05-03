package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository , 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입
public interface QuestionRepository extends JpaRepository<Question, Integer> 
{

}