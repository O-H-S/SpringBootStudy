package com.example.demo.answer;

import jakarta.validation.constraints.NotEmpty;


public class AnswerForm 
{
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
    public String getContent() 
    {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}