package com.quimbaya.fastreading.pais.aplicacion.usescases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.in.FindPaisByIdUseCase;
import com.quimbaya.fastreading.pais.domain.port.in.UpdatePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FindPaisByIdUsecaseImpl implements FindPaisByIdUseCase  {
	
	private final PaisRepositoryPort  paisRepositoryPort;

	@Override
	public Optional<Pais> findById(Long id) {
		// TODO Auto-generated method stub
		return paisRepositoryPort.findById(id);
	}	
}
