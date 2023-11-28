package com.quimabaya.fastreading.security.aplication.service;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quimabaya.fastreading.user.domain.exception.UserNotFoundException;
import com.quimabaya.fastreading.user.domain.model.Users;
import com.quimabaya.fastreading.user.domain.port.out.UserRepositoryPort;
import com.quimabaya.fastreading.user.infraestructure.persistance.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class AuthenticationService implements UserDetailsService {

	
	    private final UserRepositoryPort userRepositoryPort;
	    private final JwtUtil jwtService;
	    private final PasswordEncoder passwordEncoder;
	    private final AuthenticationManager authenticationManager;
	    
	    public String authenticate(String userEmail, String userPass) {
	        Users user = userRepositoryPort.findByEmail(userEmail)
	                .orElseThrow(()->new UserNotFoundException((long) 1));
	               
	        Authentication  authenticationToken = new UsernamePasswordAuthenticationToken(userEmail, userPass);
	        //Authentication authentication = authenticationManager.authenticate(authenticationToken);
	        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
	        if (authentication.isAuthenticated()) {
	            return jwtService.create(user.getUserName());
	        } else {
	            return "Usuario o contraseña incorrectos";
	        }
	    }

		@Override
		public UserDetails loadUserByUsername(String  userEmail) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			Users userEntity = userRepositoryPort.findByEmail(userEmail)
					 .orElseThrow(()->new UserNotFoundException((long) 1));

		        System.out.println(userEntity);

		        //String[] roles = userEntity.getUserRolId().toString();

		        return User.builder()
		                .username(userEntity.getUserName())
		                .password(userEntity.getUserPass())
		                .roles(userEntity.getUserRolId().toString())
		                .build();
		}
	    
	    
}
