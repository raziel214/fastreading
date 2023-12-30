package com.quimbaya.fastreading.ciudad.domain.port.in;

import java.util.Optional;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;

public interface FindCiudadByIdUseCase {
	
	Optional<Ciudad>findById(Long id);

}
