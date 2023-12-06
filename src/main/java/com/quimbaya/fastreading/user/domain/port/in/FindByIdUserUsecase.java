package com.quimbaya.fastreading.user.domain.port.in;

import java.util.Optional;

import com.quimbaya.fastreading.user.domain.model.Users;



public interface FindByIdUserUsecase {

	Optional<Users> findById(Long id);
}
