package com.yghee.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // @Controller, @ControllerAdvice 등을 사용
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 Bean을 주입 받기
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, GET, POST 등에 대한 테스트, MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc로 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())  // perform의 결과 검증 즉 HEADER의 상태 검증
                .andExpect(content().string("hello"));  // hello를 리턴하는 지 검증
    }
}
