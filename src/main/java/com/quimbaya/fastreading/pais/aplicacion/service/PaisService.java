package com.quimbaya.fastreading.pais.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.in.CreatePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.in.DeletePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.in.FetchAllPaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.in.FindPaisByIdUseCase;
import com.quimbaya.fastreading.pais.domain.port.in.UpdatePaisUseCase;

public class PaisService implements CreatePaisUseCase, DeletePaisUseCase, FetchAllPaisUseCase, FindPaisByIdUseCase, UpdatePaisUseCase{
	
	 private final CreatePaisUseCase createPaisUseCase;
	 private final DeletePaisUseCase deletePaisUseCase;
	 private final FetchAllPaisUseCase fetchAllPaisUseCase;
	 private final FindPaisByIdUseCase findPaisByIdUseCase;
	 private final UpdatePaisUseCase updatePaisUseCase;
	 
	public PaisService(CreatePaisUseCase createPaisUseCase, DeletePaisUseCase deletePaisUseCase,
			FetchAllPaisUseCase fetchAllPaisUseCase, FindPaisByIdUseCase findPaisByIdUseCase,
			UpdatePaisUseCase updatePaisUseCase) {
		this.createPaisUseCase = createPaisUseCase;
		this.deletePaisUseCase = deletePaisUseCase;
		this.fetchAllPaisUseCase = fetchAllPaisUseCase;
		this.findPaisByIdUseCase = findPaisByIdUseCase;
		this.updatePaisUseCase = updatePaisUseCase;
	}

	@Override
	public Pais updatePais(Long id, Pais pais) {
		// TODO Auto-generated method stub
		return updatePaisUseCase.updatePais(id, pais);
	}

	@Override
	public Optional<Pais> findById(Long id) {
		// TODO Auto-generated method stub
		return findPaisByIdUseCase.findById(id);
	}

	@Override
	public List<Pais> fetchAll() {
		// TODO Auto-generated method stub
		return fetchAllPaisUseCase.fetchAll();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return deletePaisUseCase.deleteById(id);
	}

	@Override
	public Pais createPais(Pais pais) {
		// TODO Auto-generated method stub
		return createPaisUseCase.createPais(pais);
	}
	 
	 

}
