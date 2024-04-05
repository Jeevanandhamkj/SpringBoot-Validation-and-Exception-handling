package com.example.ResponseEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Validated
@EnableWebMvc
public class ResponseEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseEntityApplication.class, args);
	}

}
