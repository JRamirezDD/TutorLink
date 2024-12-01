package com.tutorlink.tutor_domain.functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FunctionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalApplication.class, args);
	}

}
