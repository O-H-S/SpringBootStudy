package com.example.demo.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;

//@RequestMapping : 모든 HTTP 요청 메소드(GET, POST, PUT, DELETE 등)를 처리할 수 있습니다.
@RequestMapping("/question")
@Controller
public class QuestionController 
{

	private final QuestionService questionService;
    
    public QuestionController(QuestionService repo)
    {   	
    	this.questionService = repo;
    }
    
    // @GetMapping : @RequestMapping(..., method = RequestMethod.GET)의 축약형, 메소드 수준에서만 사용 가능.
    @GetMapping("/list")
    public String list(Model model) 
    {
        List<QuestionSummaryDTO> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) 
    {
    	QuestionDetailDTO question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}