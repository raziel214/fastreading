package com.quimbaya.fastreading.ciudad.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.quimbaya.fastreading.pais.domain.exception.PaisNotFoundException;

@ControllerAdvice
public class GlobalExceptionCiudadHandler {

	
	  @ExceptionHandler(CiudadNotFoundException.class)
	    public ResponseEntity<String> handlePaisNotFoundException(PaisNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
}
