package com.quimbaya.fastreading.pais.domain.port.in;

import java.util.List;

import com.quimbaya.fastreading.pais.domain.model.Pais;

public interface FetchAllPaisUseCase {

	List<Pais> fetchAll();

}
