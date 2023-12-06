package com.quimbaya.fastreading.user.aplication.usescases;

import com.quimbaya.fastreading.user.domain.model.LoginUser;
import com.quimbaya.fastreading.user.domain.model.Users;
import com.quimbaya.fastreading.user.domain.port.in.LoginUserUseCase;
import com.quimbaya.fastreading.user.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class LoginRequestUseCaseImpl implements LoginUserUseCase {
	
	private final UserRepositoryPort userRepositoryPort;
	
	


	@Override
	public LoginUser authenticate(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return userRepositoryPort.findByEmailAndPassword(loginUser.getUserEmail(),loginUser.getUserPass());
	}



	@Override
	public Users findByEmail(String email) {
	    return userRepositoryPort.findByEmail(email)
	        .orElseThrow(() -> new IllegalArgumentException("No Users found with email: " + email));
	}

}
