package com.example.demo.question;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.demo.DataNotFoundException;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;

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
    
    public Question getQuestion(Integer id) 
    {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) 
        {
            return question.get();
        } 
        else 
        {
            throw new DataNotFoundException("question not found");
        }
    }
    
    
    public QuestionDetailDTO getQuestionDetail(Integer id) 
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
    
    public void create(String subject, String content) 
    {
        Question q = new Question();
        q.subject =(subject);
        q.content = (content);
        q.createDate = (LocalDateTime.now());
        
        System.out.println(q);
        this.questionRepository.save(q);
    }
    
    public Page<Question> getListOnPage(int page) 
    {
    	 List<Sort.Order> sorts = new ArrayList<>();
         sorts.add(Sort.Order.desc("createDate"));
    	
        // Sort.by(소트리스트)로 소트 객체를 생성
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
    
}