package com.example.demo.question;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.demo.DataNotFoundException;


@Service
public class QuestionService 
{

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository repo)
    {   	
    	this.questionRepository = repo;
    }
    
    
    public List<QuestionSummaryDTO> getList() 
    {
    	List<QuestionSummaryDTO> transformed = new ArrayList<QuestionSummaryDTO>();
    	List<Question> results =  this.questionRepository.findAll();
    	for(Question ques : results)
    	{
    		transformed.add(new QuestionSummaryDTO(ques));
    	}
    	return transformed;
    }
    
    public QuestionDetailDTO getQuestion(Integer id) 
    {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) 
        {
            return new QuestionDetailDTO(question.get());
        } 
        else 
        {
            throw new DataNotFoundException("question not found");
        }
    }
}