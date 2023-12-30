package com.quimbaya.fastreading.ciudad.domain.port.in;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;

public interface UpdateCiudadUseCase {
	
	Ciudad updateCiudad (Long id,Ciudad ciudad);
}
