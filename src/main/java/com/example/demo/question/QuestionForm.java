package com.example.demo.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



// get~() 를 반드시 만들어줘야한다. 내부적으로 호출함.
public class QuestionForm 
{
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    public String subject = "";
    public String getSubject() 
    {
        return subject;
    }
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }
    
    
    @NotEmpty(message="내용은 필수항목입니다.")
    public String content = "";
    public String getContent() 
    {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}