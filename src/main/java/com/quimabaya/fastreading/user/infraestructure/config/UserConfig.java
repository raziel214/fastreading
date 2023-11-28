package com.quimabaya.fastreading.user.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quimabaya.fastreading.user.domain.port.out.UserRepositoryPort;
import com.quimabaya.fastreading.user.infraestructure.persistance.repository.JpaUserRepositoryAdapter;


@Configuration
public class UserConfig {

	
	@Bean
	public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
		
		return jpaUserRepositoryAdapter;
	
   }
}
