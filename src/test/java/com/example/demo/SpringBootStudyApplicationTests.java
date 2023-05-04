package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.QuestionRepository;


@SpringBootTest // SbbApplicationTests 클래스가 스프링부트 테스트 클래스임을 의미한다.
class SpringBootStudyApplicationTests 
{
	@Autowired //스프링의 DI 기능으로 questionRepository 객체를 스프링이 자동으로 생성
	// DI(Dependency Injection) - 스프링이 객체를 대신 생성하여 주입한다.
	// 테스트 코드의 경우에는 생성자를 통한 객체의 주입이 불가능하므로 테스트 코드 작성시에만 @Autowired를 사용
	// 실제 코드 작성시에는 생성자를 통한 객체 주입방식을 사용하겠다.
    private QuestionRepository questionRepository;
	
	
	 @Autowired
	private AnswerRepository answerRepository;
	
	@Transactional //메서드가 종료될 때까지 DB 세션이 유지된다.
	@Test  // 테스트 메서드임을 나타낸다. 위 클래스를 JUnit으로 실행하면 @Test 애너테이션이 붙은 메서드가 실행된다.
	void testJpa() 
	{        
		/*
        Question q1 = new Question();
        q1.subject = "sbb가 무엇인가요?";
        q1.content ="sbb에 대해서 알고 싶습니다.";
        q1.createDate = LocalDateTime.now();
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.subject = "sbb가 무엇인가요?22";
        q2.content ="sbb에 대해서 알고 싶습니다.22";
        q2.createDate = LocalDateTime.now();
        this.questionRepository.save(q2);  // 두번째 질문 저장
        
		
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.subject);
        
		
		// Optional은 null 처리를 유연하게 처리하기 위해 사용하는 클래스로 위와 같이 isPresent로 null이 아닌지를 확인한 후에 get으로 실제 Question 객체 값을 얻어야 한다.
        
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) 
        {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.subject);
        }
        
        this.questionRepository.delete(q);
        
        
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%"); // %sbb%, 
        Question q = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q.subject);
        
        
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
        */
    }
    
	
	
	
	
	
	void contextLoads() 
	{
		
		
	}

}
