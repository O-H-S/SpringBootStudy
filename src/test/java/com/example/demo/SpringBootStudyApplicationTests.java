package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class SpringBootStudyApplicationTests 
{
	@Autowired //스프링의 DI 기능으로 questionRepository 객체를 스프링이 자동으로 생성
	// DI(Dependency Injection) - 스프링이 객체를 대신 생성하여 주입한다.
	// 테스트 코드의 경우에는 생성자를 통한 객체의 주입이 불가능하므로 테스트 코드 작성시에만 @Autowired를 사용
	// 실제 코드 작성시에는 생성자를 통한 객체 주입방식을 사용하겠다.
    private QuestionRepository questionRepository;
	
	@Test
	void testJpa() 
	{        
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
    }
	
	
	 // 테스트 메서드임을 나타낸다. 위 클래스를 JUnit으로 실행하면 @Test 애너테이션이 붙은 메서드가 실행된다.
	void contextLoads() {
	}

}
