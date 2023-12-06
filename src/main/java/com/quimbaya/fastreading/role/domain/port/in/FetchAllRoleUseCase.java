package com.quimbaya.fastreading.role.domain.port.in;

import java.util.List;

import com.quimbaya.fastreading.role.domain.model.Role;

public interface FetchAllRoleUseCase {

	 List<Role> fetchAll();
}
