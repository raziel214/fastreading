package com.quimbaya.fastreading.pais.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionPaisHandler {

    @ExceptionHandler(PaisNotFoundException.class)
    public ResponseEntity<String> handlePaisNotFoundException(PaisNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    // ... otros manejadores de excepción ...
}






