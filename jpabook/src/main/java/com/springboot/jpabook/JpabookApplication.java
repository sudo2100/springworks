package com.springboot.jpabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpabookApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpabookApplication.class, args);
	}

}
