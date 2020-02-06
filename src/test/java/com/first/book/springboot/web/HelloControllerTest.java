package com.first.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴 즉,스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) //여러 스프링 어노테이션 중,Web(Spring MVC)에 집중 할수 있는 어노테이션. 선언시 @Controller,@ControllerAdvice등 사용가능
public class HelloControllerTest { //단@service @Component @Repository등은 사용x 지금은 Comtroller만 사용하기에 사용

        @Autowired //스프링이 관리하는 빈(Bean)을 주입 받음
        private MockMvc mvc; //웹 API를 테스트 할때 사용. 스프링MVC테스트의 시작점. 이 class를 통해 HTTP GET,POST 등에 대한 API테스트 가능

        @Test
        public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
        //mvc.perform(get("/hello")) MockMvc를 통해 /hello주소로 HTTP GET요청을 합니다. 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 할 수 있음
        //.andExpect(status().isOk()) mvc.perform의 결과를 검증. HTTP Header의 Status를 검증.
            // 우리가 흔히 아는 200,404,500등의 상태 검증
            //여기서는 200인지 아닌지 확인
        //.andExpect(content().string(hello)) mvc.perform의 결과 증.
            //응답 본문의 내용을 검증
            //Controller에서 "hello"를 return하기 때문에 이 값이 맞는지 검증
    }

        @Test
        public void helloDto가_리턴된다() throws Exception{
                String name = "hello";
                int amount = 1000;

                mvc.perform(
                        get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name", is(name)))
                        .andExpect(jsonPath("$.amount",is(amount)));

                //@RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
                //여기서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장함
                //Param API테스트 할 때 사용될 요청 파라미터를 설정.단 값은 String만 허용,그래서 숫자/날짜 등의 데이터도 등록시에는 문자열로 변경해야함
                //jsonPath JSON응답값을 필드별로 검증할 수 있는 메소드.$를 기준으로 필드명을 명시.여기서는 name과amount를 검증하니 $.name $.amount로 검증
        }
}
