package com.quimbaya.fastreading.role.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.in.FindRoleByIdUseCase;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Service
public class FindRoleByIdUsecaseImpl implements FindRoleByIdUseCase {
	private final RoleRepositoryPort roleRepositoryPort;  

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepositoryPort.findById(id);
    }

}
