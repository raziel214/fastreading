package com.quimabaya.fastreading.user.domain.port.in;

import com.quimabaya.fastreading.user.domain.model.LoginUser;
import com.quimabaya.fastreading.user.domain.model.Users;

public interface LoginUserUseCase {
	LoginUser authenticate(LoginUser loginUser);
	Users findByEmail(String Email);
}
