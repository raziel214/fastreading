package com.quimbaya.fastreading.user.domain.port.in;

import com.quimbaya.fastreading.user.domain.model.Users;
import com.quimbaya.fastreading.user.domain.model.LoginUser;

public interface LoginUserUseCase {
	LoginUser authenticate(LoginUser loginUser);
	Users findByEmail(String Email);
}
