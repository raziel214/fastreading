package com.quimbaya.fastreading.security.domain.exception;

public class InvalidCredentialsException extends RuntimeException {
	
	public InvalidCredentialsException() {
		super("Usuario o contraseña incorrectos");
	}

}
