package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class SpringBootStudyApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootStudyApplication.class, args);
		
		
		
		/*
		ScreenCapture capture = new ScreenCapture();

		Timer timer = new Timer();
        TimerTask task = new TimerTask() 
        {
            @Override
            public void run() 
            {
            	capture.shot();
            }
        };

        long delay = 5000L; // 2초 후에 실행
        timer.schedule(task, delay);
		*/
		
		
	}

}
