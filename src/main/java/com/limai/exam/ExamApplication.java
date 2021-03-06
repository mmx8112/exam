package com.limai.exam;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("com.limai.exam.dao")
@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
		log.info("11111111111");
	}

}
