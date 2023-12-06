package com.quimbaya.fastreading.user.domain.exception;

public class InvalidCredentialsException extends RuntimeException {

	
	public InvalidCredentialsException() {
		super("Usuario o contraseña incorrectos");
	}
}
