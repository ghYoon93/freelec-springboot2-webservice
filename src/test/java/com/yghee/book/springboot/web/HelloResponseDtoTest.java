package com.yghee.book.springboot.web;

import com.yghee.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  // 검증하고 싶은 대상(dto.get~())을 메소드 인자로 받음
        assertThat(dto.getAmount()).isEqualTo(amount);  // asertj의 동등 비교 메소드, assertThat과 isEqualsTo 값이 같을 때만 성공
    }
}
