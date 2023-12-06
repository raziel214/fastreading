package com.quimbaya.fastreading.role.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quimbaya.fastreading.role.infrastructure.persistence.entity.RoleEntity;

@Repository
public interface  JpaRoleRepository extends JpaRepository<RoleEntity, Long> {

	
}
