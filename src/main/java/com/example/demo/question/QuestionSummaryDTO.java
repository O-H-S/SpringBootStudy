package com.example.demo.question;


public class QuestionSummaryDTO 
{
	public Integer id;
    public String subject;
	
    public QuestionSummaryDTO(Question qEntity)
    {
    	id = qEntity.GetID();
    	subject = qEntity.subject;  	
    }
    
}
