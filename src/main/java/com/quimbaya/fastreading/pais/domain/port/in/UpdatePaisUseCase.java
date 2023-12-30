package com.quimbaya.fastreading.pais.domain.port.in;

import com.quimbaya.fastreading.pais.domain.model.Pais;

public interface UpdatePaisUseCase {

	Pais updatePais (Long id,Pais pais);
}
