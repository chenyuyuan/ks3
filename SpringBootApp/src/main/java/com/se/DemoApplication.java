package com.se;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@Configuration

@RestController
@SpringBootApplication
@MapperScan("com.se.mapper")
@Import(DemoConfiguration.class)
public class DemoApplication {


	//@RequestMapping("/hello")
	//public String index(){
	//	return "Hello World";
	//}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
