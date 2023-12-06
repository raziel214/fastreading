package com.quimbaya.fastreading.role.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.role.domain.model.Role;

public interface RoleRepositoryPort {
	 
	Role save(Role role);
    Optional<Role> findById(Long id);
    List<Role> findAll();
    Optional<Role> update(Role role);
    boolean deleteById(Long id);
}
