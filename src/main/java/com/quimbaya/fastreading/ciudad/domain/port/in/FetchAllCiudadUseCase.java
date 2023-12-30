package com.quimbaya.fastreading.ciudad.domain.port.in;

import java.util.List;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;

public interface FetchAllCiudadUseCase {

	List<Ciudad> fetchAll();
}
