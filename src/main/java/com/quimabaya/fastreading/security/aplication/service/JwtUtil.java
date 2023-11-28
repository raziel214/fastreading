package com.quimabaya.fastreading.security.aplication.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class JwtUtil {
	
	  @Value("${jwt.secret}")
	  private  String SECRET_KEY;
	  
	  @Value("${jwt.issuer}")
	  private String issuer;
	  
	  @Value("${jwt.expiration}")
	  private long expirationTime;  
	 
	  
	 

	public String create(String userName) {
		//ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
		 
		  Date now = new Date(); 
		  Date expiryDate = new Date(now.getTime() + expirationTime);
		  return JWT.create()
				  .withSubject(userName)
				  .withIssuer(issuer)
				  .withIssuedAt(now)
				  .withExpiresAt(expiryDate)
				  .sign(Algorithm.HMAC256(SECRET_KEY));
	  }
	  
	  public boolean isValid(String jwt) {
	        try {
	            JWT.require(Algorithm.HMAC256(SECRET_KEY))
	                    .build()
	                    .verify(jwt);
	            return true;
	        } catch (JWTVerificationException e) {
	            return false;
	        }
	    }

	    public String getUsername(String jwt) {
	        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
	                .build()
	                .verify(jwt)
	                .getSubject();
	    }

}
