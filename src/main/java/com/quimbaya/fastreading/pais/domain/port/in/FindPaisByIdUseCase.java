package com.quimbaya.fastreading.pais.domain.port.in;

import java.util.Optional;

import com.quimbaya.fastreading.pais.domain.model.Pais;

public interface FindPaisByIdUseCase {
	
	Optional<Pais> findById(Long id);

}
