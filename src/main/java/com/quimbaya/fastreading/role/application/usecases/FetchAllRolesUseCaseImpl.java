package com.quimbaya.fastreading.role.application.usecases;

import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.in.FetchAllRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Data
@AllArgsConstructor
@Service
public class FetchAllRolesUseCaseImpl implements FetchAllRoleUseCase {

    private final RoleRepositoryPort roleRepositoryPort;

    @Override
    public List<Role> fetchAll() {
        return roleRepositoryPort.findAll()
                .stream()
                .map(this::convertRoleToDomain)
                .collect(Collectors.toList());
    }

    private Role convertRoleToDomain(Role roleFromRepo) {
        return roleFromRepo;
    }
}
