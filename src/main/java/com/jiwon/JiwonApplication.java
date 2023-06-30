package com.jiwon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JiwonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiwonApplication.class, args);
	}

}
