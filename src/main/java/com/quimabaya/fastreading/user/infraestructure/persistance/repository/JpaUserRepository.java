package com.quimabaya.fastreading.user.infraestructure.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quimabaya.fastreading.user.infraestructure.persistance.entity.UserEntity;


@Repository
public interface JpaUserRepository {
	
		Optional<UserEntity> findByUserEmailAndUserPass(String userEmail, String userPass);
		Optional<UserEntity> findByUserEmail(String userEmail);

	
}
