package com.quimbaya.fastreading.role.application.service;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.in.CreatedRoleUseCase;
import com.quimbaya. fastreading.role.domain.port.in.DeleteRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.in.FetchAllRoleUseCase;
import com.quimbaya.fastreading.role.domain.port.in.FindRoleByIdUseCase;
import com.quimbaya.fastreading.role.domain.port.in.UpdateRoleUseCase;


public class RoleService implements CreatedRoleUseCase, DeleteRoleUseCase, FetchAllRoleUseCase, FindRoleByIdUseCase, UpdateRoleUseCase {

    private final CreatedRoleUseCase createdRoleUseCase;
    private final DeleteRoleUseCase deleteRoleUseCase;
    private final FetchAllRoleUseCase fetchAllRoleUseCase;
    private final FindRoleByIdUseCase findRoleByIdUseCase;
    private final UpdateRoleUseCase updateRoleUseCase;

    public RoleService(CreatedRoleUseCase createdRoleUseCase, DeleteRoleUseCase deleteRoleUseCase,
                       FetchAllRoleUseCase fetchAllRoleUseCase, FindRoleByIdUseCase findRoleByIdUseCase,
                       UpdateRoleUseCase updateRoleUseCase) {
        this.createdRoleUseCase = createdRoleUseCase;
        this.deleteRoleUseCase = deleteRoleUseCase;
        this.fetchAllRoleUseCase = fetchAllRoleUseCase;
        this.findRoleByIdUseCase = findRoleByIdUseCase;
        this.updateRoleUseCase = updateRoleUseCase;
    }

    @Override
    public Role createdRole(Role role) {
        return createdRoleUseCase.createdRole(role);
    }

    @Override
    public boolean deleteById(Long id) {
        return deleteRoleUseCase.deleteById(id);
    }

    @Override
    public List<Role> fetchAll() {
        return fetchAllRoleUseCase.fetchAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return findRoleByIdUseCase.findById(id);
    }

    @Override
    public Role updateRole(Long id, Role updatedRole) {
        return updateRoleUseCase.updateRole(id, updatedRole);
    }
}
