package com.library.pr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrApplication.class, args);
	}

}
