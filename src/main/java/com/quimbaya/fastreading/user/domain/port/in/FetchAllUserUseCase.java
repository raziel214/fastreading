package com.quimbaya.fastreading.user.domain.port.in;

import java.util.List;

import com.quimbaya.fastreading.user.domain.model.Users;



public interface FetchAllUserUseCase {
	List<Users> fetchAll();

}
