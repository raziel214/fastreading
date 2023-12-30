package com.quimbaya.fastreading.pais.aplicacion.usescases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.in.FetchAllPaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FetchAllPaisUseCaseImpl implements FetchAllPaisUseCase{
	
	private final PaisRepositoryPort paisRepositoryPort;

	@Override
	public List<Pais> fetchAll() {
		// TODO Auto-generated method stub
		return paisRepositoryPort.findAll()
				.stream()
				.map(this::convertPaisToDomain)
				.collect(Collectors.toList());
	}
	private Pais convertPaisToDomain (Pais  paisFromRepo) {
		
		return paisFromRepo;		
	}

}
