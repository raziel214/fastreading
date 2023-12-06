package com.quimbaya.fastreading.role.application.usecases;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.role.domain.port.in.DeleteRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class DeleteRoleUsecaseImpl implements DeleteRoleUseCase {
	
	private final RoleRepositoryPort roleRepositoryPort;
    @Override
    public boolean deleteById(Long id) {
        return roleRepositoryPort.deleteById(id);
    }	

}
