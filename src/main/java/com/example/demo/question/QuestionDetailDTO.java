package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.answer.Answer;

public class QuestionDetailDTO 
{
	public Integer id;
    public String subject;
    public String content;
    public LocalDateTime createDate;
    public List<Answer> answerList;
    
    public QuestionDetailDTO(Question qEntity)
    {
    	id = qEntity.GetID();
    	subject = qEntity.subject;  	
    	content = qEntity.content;  	
    	answerList = qEntity.answerList;
    	createDate = qEntity.createDate;
    }
    
}
