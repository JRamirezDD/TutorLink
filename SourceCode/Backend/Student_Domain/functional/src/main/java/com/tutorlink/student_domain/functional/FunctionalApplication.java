package com.tutorlink.student_domain.functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FunctionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalApplication.class, args);
	}

}
