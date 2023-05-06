package com.example.demo.answer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.question.Question;

import java.util.List;

//JpaRepository , 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입
public interface AnswerRepository extends JpaRepository<Answer, Integer> 
{


}