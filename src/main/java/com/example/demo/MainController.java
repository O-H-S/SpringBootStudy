package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController 
{

    @GetMapping("/sbb")
    @ResponseBody // URL 요청에 대한 응답으로 문자열을 리턴하라는 의미이다.
    public String index() 
    {
        return "index";
    }
}