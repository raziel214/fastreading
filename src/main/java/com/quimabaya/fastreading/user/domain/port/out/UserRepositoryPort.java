package com.quimabaya.fastreading.user.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.quimabaya.fastreading.user.domain.model.LoginUser;
import com.quimabaya.fastreading.user.domain.model.Users;



public interface UserRepositoryPort {

	
    LoginUser findByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
}
