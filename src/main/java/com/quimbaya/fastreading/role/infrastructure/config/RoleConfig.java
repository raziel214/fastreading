package com.quimbaya.fastreading.role.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quimbaya.fastreading.role.application.service.RoleService;
import com.quimbaya.fastreading.role.application.usecases.CreatedRoleUseCaseImpl;
import com.quimbaya.fastreading.role.application.usecases.DeleteRoleUsecaseImpl;
import com.quimbaya.fastreading.role.application.usecases.FetchAllRolesUseCaseImpl;
import com.quimbaya.fastreading.role.application.usecases.UpdateRoleUseCaseImpl;
import com.quimbaya.fastreading.role.application.usecases.FindRoleByIdUsecaseImpl;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;
import com.quimbaya.fastreading.role.infrastructure.persistence.repository.JpaRoleRepositoryAdapter; // Importación supuesta

@Configuration
public class RoleConfig {	

    @Bean
    public RoleService roleService(RoleRepositoryPort roleRepositoryPort) {
        return new RoleService(
               new CreatedRoleUseCaseImpl(roleRepositoryPort),
               new DeleteRoleUsecaseImpl(roleRepositoryPort),
               new FetchAllRolesUseCaseImpl(roleRepositoryPort),
               new FindRoleByIdUsecaseImpl(roleRepositoryPort),
               new UpdateRoleUseCaseImpl(roleRepositoryPort)
        );
    }

    @Bean
    public RoleRepositoryPort roleRepositoryPort(JpaRoleRepositoryAdapter jpaRoleRepositoryAdapter) {
        return jpaRoleRepositoryAdapter;
    }

    
}
