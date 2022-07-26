package com.technical_evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
/*@EntityScan(basePackages = {"com.technical_evaluation.*"})
@EnableJpaRepositories(basePackages = "{com.technical_evaluation.*}")*/
public class BackendApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
