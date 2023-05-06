package com.example.demo.answer;

import java.time.LocalDateTime;

import com.example.demo.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Answer 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(columnDefinition = "TEXT")
    public String content;
    public LocalDateTime createDate;

    @ManyToOne // 여러개의 Answer : 하나의 Question, 실제 데이터베이스에서는 ForeignKey 관계 생성
    public Question question;
}