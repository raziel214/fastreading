package com.quimbaya.fastreading.user.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quimbaya.fastreading.user.aplication.service.UserService;
import com.quimbaya.fastreading.user.aplication.usescases.CreatedUserCaseImpl;
import com.quimbaya.fastreading.user.aplication.usescases.DeleteUserCaseImpl;
import com.quimbaya.fastreading.user.aplication.usescases.FetchAllUsersCaseImpl;
import com.quimbaya.fastreading.user.aplication.usescases.FindUserCaseByIdImpl;
import com.quimbaya.fastreading.user.aplication.usescases.UpdateUserCaseImpl;
import com.quimbaya.fastreading.user.aplication.usescases.LoginRequestUseCaseImpl;
import com.quimbaya.fastreading.user.domain.port.out.UserRepositoryPort;
import com.quimbaya.fastreading.user.infraestructure.persistance.repository.JpaUserRepositoryAdapter;

@Configuration
public class UserConfig {
	
	
	@Bean
	public UserService userService(UserRepositoryPort userRepositoryPort) {
		return new UserService(
				new CreatedUserCaseImpl(userRepositoryPort, null),
				new DeleteUserCaseImpl(userRepositoryPort),
				new FetchAllUsersCaseImpl(userRepositoryPort),
				new FindUserCaseByIdImpl(userRepositoryPort), 
				new UpdateUserCaseImpl(userRepositoryPort),
				new LoginRequestUseCaseImpl(userRepositoryPort));		
	}
	@Bean
	public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
		
		return jpaUserRepositoryAdapter;
	
   }

}
