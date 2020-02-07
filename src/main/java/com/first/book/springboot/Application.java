package com.first.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
스프링부트의 자동 설정, 스프링 Bean읽기와 생성 모두 자동으로 설정.
특히 @SpringBootApplication부터 읽기때문에 최상단에 위치필수
@EnableJpaAuditing JPA Auditing 활성화
*/
