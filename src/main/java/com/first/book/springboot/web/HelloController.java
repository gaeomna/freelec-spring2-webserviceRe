package com.first.book.springboot.web;


import com.first.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controller를 JSON을 반환하는 Controller로 만들어줌
public class HelloController {

    @GetMapping("/hello") //@getmapping는 HTTP Method인 get의 요청을 받을 수 있는 API를 만들어줌
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
