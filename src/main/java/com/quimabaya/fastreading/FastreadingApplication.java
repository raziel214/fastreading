package com.quimabaya.fastreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.quimbaya.fastreading")
@ComponentScan(basePackages = "com.quimbaya.fastreading")
@EnableJpaRepositories(basePackages = {
		"com.quimbaya.fastreading"
})
@EntityScan(basePackages = {
		"com.quimbaya.fastreading"
})
public class FastreadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastreadingApplication.class, args);
	}

}
