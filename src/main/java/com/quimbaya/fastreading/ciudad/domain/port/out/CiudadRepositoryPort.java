package com.quimbaya.fastreading.ciudad.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;

public interface CiudadRepositoryPort {

	Ciudad save(Ciudad ciudad);
	Optional<Ciudad> findById(Long id);
	List<Ciudad> findAll();
	Optional<Ciudad> update(Ciudad ciudad);
	boolean deleteById(Long id);
}
