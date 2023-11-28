package com.quimabaya.fastreading.user.infraestructure.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.quimabaya.fastreading.security.aplication.service.JwtUtil;
import com.quimabaya.fastreading.user.domain.model.LoginUser;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@RestController
@RequestMapping("/public/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginUser loginUser)
    {
    	 UsernamePasswordAuthenticationToken login = 
    			 new UsernamePasswordAuthenticationToken(loginUser.getUserEmail(), loginUser.getUserPass());
    	 Authentication authentication = (Authentication) this.authenticationManager.authenticate(login);
    	 
    	 System.out.println(authentication.isAuthenticated());
         System.out.println(authentication.getPrincipal());
         
         String jwt = this.jwtUtil.create(loginUser.getUserEmail());
         
         return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build();
         
         
          
    }
}
