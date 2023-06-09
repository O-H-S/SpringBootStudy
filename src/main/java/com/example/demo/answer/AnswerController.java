package com.example.demo.answer;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@RequestMapping("/answer")
@Controller
public class AnswerController 
{

    private final QuestionService questionService;
    private final AnswerService answerService;
    
    public AnswerController(QuestionService serv, AnswerService serv_ans)
    {   	
    	this.questionService = serv;
    	this.answerService = serv_ans;
    }
    
    
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) 
    {
        Question question = this.questionService.getQuestion(id);
        if (bindingResult.hasErrors()) 
        {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(id, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}