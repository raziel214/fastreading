package com.quimbaya.fastreading.user.domain.port.in;

import com.quimbaya.fastreading.user.domain.model.Users;

public interface UpdateUserUseCase {
	
	Users updateUser(Long id,Users user );

}
