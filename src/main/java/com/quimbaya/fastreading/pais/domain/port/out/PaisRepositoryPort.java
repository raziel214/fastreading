package com.quimbaya.fastreading.pais.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.pais.domain.model.Pais;

public interface PaisRepositoryPort {
	Pais save(Pais pais);
    Optional<Pais> findById(Long id);
    List<Pais> findAll();
    Optional<Pais> update(Pais pais);
    boolean deleteById(Long id);
}
