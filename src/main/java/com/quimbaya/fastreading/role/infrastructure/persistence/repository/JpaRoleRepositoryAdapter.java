package com.quimbaya.fastreading.role.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quimbaya.fastreading.role.domain.model.Role;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;
import com.quimbaya.fastreading.role.infrastructure.persistence.entity.RoleEntity;

@Component
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort {

 
    @Autowired
    private JpaRoleRepository jpaRoleRepository;

    @Autowired
    public JpaRoleRepositoryAdapter(JpaRoleRepository jpaRoleRepository) {
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public Role save(Role role) {
        RoleEntity entity = toEntity(role);
        entity = jpaRoleRepository.save(entity);
        return toDomain(entity);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return jpaRoleRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Role> findAll() {
        return jpaRoleRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Role> update(Role role) {
        if (jpaRoleRepository.existsById(role.getRol_id())) {
            RoleEntity entityToUpdate = toEntity(role);
            RoleEntity updatedEntity = jpaRoleRepository.save(entityToUpdate);
            return Optional.of(toDomain(updatedEntity));
        }
        return Optional.empty();
    }

   

    
    @Override
    public boolean  deleteById(Long id) {
    	if (jpaRoleRepository.existsById(id)) {
            jpaRoleRepository.deleteById(id);
            return true;  // El rol existía y fue eliminado
        } else {
            return false; // El rol no existía
        }
    }
    private RoleEntity toEntity(Role role) {
        return new RoleEntity(
        		role.getRol_id(),
        		role.getRol_name(),
        		role.getRol_descripcion());
    }

    private Role toDomain(RoleEntity entity) {
        return new Role(
        		entity.getRol_id(),
        		entity.getName(),
        		entity.getDescription());
    }
    
}
