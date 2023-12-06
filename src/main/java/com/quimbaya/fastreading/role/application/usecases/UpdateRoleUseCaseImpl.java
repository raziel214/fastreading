package com.quimbaya.fastreading.role.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.role.domain.exception.RoleNotFoundException;
import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.in.UpdateRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UpdateRoleUseCaseImpl implements UpdateRoleUseCase {

	private final RoleRepositoryPort roleRepositoryPort;
	@Override
    public Role updateRole(Long id, Role updatedRole) {
        return roleRepositoryPort.findById(id)
                                 .map(existingRole -> {
                                     existingRole.setRol_name(updatedRole.getRol_name());
                                     existingRole.setRol_descripcion(updatedRole.getRol_descripcion());
                                     return roleRepositoryPort.save(existingRole);
                                 })
                                 .orElseThrow(() -> new RoleNotFoundException(id));
    }

}
