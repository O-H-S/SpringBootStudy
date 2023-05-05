package com.example.demo.question;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.example.demo.answer.Answer;


@Entity // 이 애너테이션을 적용해야 JPA가 엔티티로 인식한다.
public class Question 
{
    @Id //  id 속성을 기본 키(primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다
    // GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가
    private Integer id;

    public Integer GetID()
    {
    	return id;
    }
    
    @Column(length = 200)
    public String subject;

    @Column(columnDefinition = "TEXT") 
    public String content;
    public LocalDateTime createDate; // 실제 테이블의 컬럼명은 create_date
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // Answer 엔티티들의 question 컬럼을 기준으로
    // CascadeType.REMOVE : 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서
    public List<Answer> answerList;
}