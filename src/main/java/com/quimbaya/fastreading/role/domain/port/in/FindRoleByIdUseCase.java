package com.quimbaya.fastreading.role.domain.port.in;

import java.util.Optional;

import com.quimbaya.fastreading.role.domain.model.Role;

public interface FindRoleByIdUseCase {

	  Optional<Role> findById(Long id);
}
