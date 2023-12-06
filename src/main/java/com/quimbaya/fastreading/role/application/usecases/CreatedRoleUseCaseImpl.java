package com.quimbaya.fastreading.role.application.usecases;



import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.in.CreatedRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class CreatedRoleUseCaseImpl implements CreatedRoleUseCase {

	private final RoleRepositoryPort roleRepositoryPort;   
	@Override
	public Role createdRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepositoryPort.save(role);
	}


}

