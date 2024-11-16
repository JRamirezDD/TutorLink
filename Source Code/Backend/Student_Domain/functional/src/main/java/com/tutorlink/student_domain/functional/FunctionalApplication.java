package com.tutorlink.student_domain.functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FunctionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalApplication.class, args);
	}

}
