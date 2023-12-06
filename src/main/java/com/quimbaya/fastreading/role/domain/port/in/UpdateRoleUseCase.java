package com.quimbaya.fastreading.role.domain.port.in;

import com.quimbaya.fastreading.role.domain.model.Role;

public interface UpdateRoleUseCase {
	  Role updateRole(Long id, Role updatedRole);
}
