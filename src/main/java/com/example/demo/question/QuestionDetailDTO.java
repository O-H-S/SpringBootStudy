package com.example.demo.question;


public class QuestionDetailDTO 
{
	public Integer id;
    public String subject;
    public String content;
	
    public QuestionDetailDTO(Question qEntity)
    {
    	id = qEntity.GetID();
    	subject = qEntity.subject;  	
    	content = qEntity.content;  	
    }
    
}
