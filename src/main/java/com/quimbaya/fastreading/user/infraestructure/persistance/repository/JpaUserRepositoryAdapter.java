package com.quimbaya.fastreading.user.infraestructure.persistance.repository;


import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quimbaya.fastreading.role.infrastructure.persistence.entity.RoleEntity;
import com.quimbaya.fastreading.role.infrastructure.persistence.repository.JpaRoleRepository;
import com.quimbaya.fastreading.user.domain.exception.InvalidCredentialsException;
import com.quimbaya.fastreading.user.domain.model.LoginUser;
import com.quimbaya.fastreading.user.domain.model.Users;
import com.quimbaya.fastreading.user.domain.port.out.UserRepositoryPort;
import com.quimbaya.fastreading.user.infraestructure.persistance.entity.UserEntity;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
	
	@Autowired
	private JpaUserRepository jpaUserRepository;
	@Autowired
	private JpaRoleRepository jpaRoleRepository;
	

	

	public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, JpaRoleRepository jpaRoleRepository) {
		this.jpaUserRepository = jpaUserRepository;
		this.jpaRoleRepository = jpaRoleRepository;
	}


	@Override
	public Users save(Users user) {
		// TODO Auto-generated method stub
		UserEntity entity=toEntity(user);
		entity=jpaUserRepository.save(entity);
		return toDomain(entity);
	}


	@Override
	public Optional<Users> findById(Long id) {
		// TODO Auto-generated method stub
		return jpaUserRepository.findById(id).map(this::toDomain);
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return jpaUserRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}

	@Override
	public Optional<Users> update(Users user) {
		// TODO Auto-generated method stub
		if(jpaUserRepository.existsById(user.getUserId())) {
			UserEntity entityToUpdate= toEntity(user);
			UserEntity updatedEntity= jpaUserRepository.save(entityToUpdate);
			return Optional.of(toDomain(updatedEntity));
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if(jpaUserRepository.existsById(id)){
			jpaUserRepository.deleteById(id);
			return true;
			}
		else {
			return false;
		}
	}
	
	private UserEntity toEntity(Users user) {
	    Optional<RoleEntity> optionalRoleEntity = jpaRoleRepository.findById(user.getUserRolId());
	    if (!optionalRoleEntity.isPresent()) {
	        throw new IllegalArgumentException("No Role found with ID: " + user.getUserRolId());
	    }
	    
	   

	    RoleEntity userRoleEntity = optionalRoleEntity.get();
	    

	    return new UserEntity(
	        user.getUserId(),
	        user.getUserName(),
	        user.getUserLastName(),
	        user.getUserEmail(),
	        user.getUserPass(),
	        userRoleEntity,
	        LocalDateTime.ofInstant(user.getDateCreation().toInstant(), ZoneId.systemDefault()), // Convertir java.util.Date a LocalDateTime
	        LocalDateTime.ofInstant(user.getDateUpdate().toInstant(), ZoneId.systemDefault()),
	        user.getDateDelete() != null ? LocalDateTime.ofInstant(user.getDateDelete().toInstant(), ZoneId.systemDefault()) : null,
	        user.getState(),
	        user.getFirst(),
	        user.getRecoveryPass()
	        
	    );
	}


	

	private Users toDomain(UserEntity entity) {
	    return new Users(
	        entity.getUserId(),
	        entity.getUserName(),
	        entity.getUserLastName(),
	        entity.getUserEmail(),
	        entity.getUserPass(),
	        entity.getUserRole().getRol_id(), // Aquí solo obtenemos el ID del rol
	        Date.from(entity.getDateCreation().atZone(ZoneId.systemDefault()).toInstant()), // Convertir LocalDateTime a java.util.Date
	        Date.from(entity.getDateUpdate().atZone(ZoneId.systemDefault()).toInstant()),
	        entity.getDateDelete() != null ? Date.from(entity.getDateDelete().atZone(ZoneId.systemDefault()).toInstant()) : null,
	        entity.getState(),
	        entity.getFirst(),
	        entity.getRecoveryPass()
	       
	    );
	}




	@Override
	public LoginUser findByEmailAndPassword(String email, String password) {
		Optional<UserEntity> userEntity = jpaUserRepository.findByUserEmailAndUserPass(email, password);
	    if (userEntity.isPresent()) {
	        UserEntity entity = userEntity.get();
	        return new LoginUser(entity.getUserEmail(), entity.getUserPass());
	    } else {
	        throw new InvalidCredentialsException();
	    }
	}


	@Override
	public Optional<Users> findByEmail(String email) {
	    return jpaUserRepository.findByUserEmail(email).map(this::toDomain);
	}

}
