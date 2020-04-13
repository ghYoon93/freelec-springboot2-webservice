package com.yghee.book.springboot.web;

import com.yghee.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)}) // @Controller, @ControllerAdvice 등을 사용
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 Bean을 주입 받기
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, GET, POST 등에 대한 테스트, MVC 테스트의 시작점

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc로 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())  // perform의 결과 검증 즉 HEADER의 상태 검증
                .andExpect(content().string("hello"));  // hello를 리턴하는 지 검증
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                        .param("name", name)  // API 테스트 시 사용될 요청 파라미터 설정 (String만 허용)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))  // JSON 응답값을 필드별로 검증하는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
