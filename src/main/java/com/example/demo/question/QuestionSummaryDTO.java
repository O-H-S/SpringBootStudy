package com.example.demo.question;

import java.time.LocalDateTime;

public class QuestionSummaryDTO 
{
	public Integer id;
    public String subject;
    public LocalDateTime createDate;
    public QuestionSummaryDTO(Question qEntity)
    {
    	id = qEntity.GetID();
    	subject = qEntity.subject;  	
    	createDate = qEntity.createDate;
    }
    
}
