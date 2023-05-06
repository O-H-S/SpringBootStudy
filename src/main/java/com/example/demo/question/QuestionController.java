package com.example.demo.question;
import com.example.demo.answer.AnswerService;
import com.example.demo.answer.Answer;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.example.demo.answer.AnswerForm;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

//@RequestMapping : 모든 HTTP 요청 메소드(GET, POST, PUT, DELETE 등)를 처리할 수 있습니다.
@RequestMapping("/question")
@Controller
public class QuestionController 
{

	private final QuestionService questionService;
	private final AnswerService answerService;
	
    public QuestionController(QuestionService repo, AnswerService ansS)
    {   	
    	this.questionService = repo;
    	this.answerService = ansS;
    }
    
    // @GetMapping : @RequestMapping(..., method = RequestMethod.GET)의 축약형, 메소드 수준에서만 사용 가능.
    //  " /list?page=0"
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) 
    {
        Page<Question> paging = this.questionService.getListOnPage(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }
    
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) 
    {
    	QuestionDetailDTO question = this.questionService.getQuestionDetail(id);
    	//List<Answer> answerList =  this.answerService.getList();
        model.addAttribute("question", question);
        //model.addAttribute("answerList", answerList);
        return "question_detail";
    }
    
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) 
    {
        return "question_form";
    }
    
    //메서드 오버로딩
    // 이때 인자명은  html파일 내의 엘리먼트의 "name=~~"과 같아야한다.  
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) 
    {
    	//BindingResult가 Model의 역할을 한다?
        if (bindingResult.hasErrors()) 
        {
            return "question_form";
        }
        this.questionService.create(questionForm.subject, questionForm.content);

        // redirect이므로, 별도의 model을 작성할 필요 없다.
        return "redirect:/question/list";
    }
}