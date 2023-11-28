package com.quimabaya.fastreading.user.aplicartion.service;



import com.quimabaya.fastreading.user.domain.model.LoginUser;
import com.quimabaya.fastreading.user.domain.model.Users;
import com.quimabaya.fastreading.user.domain.port.in.LoginUserUseCase;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserService implements LoginUserUseCase{
	
	private final  LoginUserUseCase   loginUserUseCase;
	
	@Override
	public LoginUser authenticate(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return loginUserUseCase.authenticate(loginUser);
	}

	@Override
	public Users findByEmail(String Email) {
		// TODO Auto-generated method stub
		return loginUserUseCase.findByEmail(Email);
	}

}
