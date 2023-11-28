package com.quimabaya.fastreading.user.infraestructure.persistance.repository;

import java.sql.Date;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quimabaya.fastreading.user.domain.exception.InvalidCredentialsException;
import com.quimabaya.fastreading.user.domain.model.LoginUser;
import com.quimabaya.fastreading.user.domain.model.Users;
import com.quimabaya.fastreading.user.domain.port.out.UserRepositoryPort;
import com.quimabaya.fastreading.user.infraestructure.persistance.entity.UserEntity;



@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort{
	
	@Autowired
	private final JpaUserRepository jpaUserRepository;

	public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
		this.jpaUserRepository = jpaUserRepository;
	}

	@Override
	public LoginUser findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		 return jpaUserRepository.findByUserEmail(email).map(this::toDomain);
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
	        entity.getRecoveryPass(),
	        entity.getUserTeam().getTeam_id()
	    );
	}


}
