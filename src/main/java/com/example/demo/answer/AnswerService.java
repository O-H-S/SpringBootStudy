package com.example.demo.answer;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionService;
import com.example.demo.question.QuestionSummaryDTO;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class AnswerService 
{

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    
    
    public AnswerService(AnswerRepository repo, QuestionService qServ)
    {  	
    	answerRepository = repo;
    	questionService = qServ;
    }
    
    
    
    public List<Answer> getList() 
    {

    	List<Answer> results =  this.answerRepository.findAll();
    	return results;
    }
    
    
    public void create(Integer quesID, String content) 
    {
    	Question question = questionService.getQuestion(quesID);
    	
        Answer answer = new Answer();
        answer.content= (content);
        answer.createDate = LocalDateTime.now();
        answer.question = question;
        this.answerRepository.save(answer);
    }
}