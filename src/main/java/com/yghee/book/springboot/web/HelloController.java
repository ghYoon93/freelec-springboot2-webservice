package com.yghee.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON으로 반환하는 컨트롤러
public class HelloController {
    @GetMapping("/hello") // Get의 요청을 받을 수 있는 API 생성
    public  String hello(){
        return "hello";
    }
}
