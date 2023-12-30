package com.quimbaya.fastreading.pais.aplicacion.usescases;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.pais.domain.exception.PaisNotFoundException;
import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.in.UpdatePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UpdatePaisUseCaseImpl implements UpdatePaisUseCase {

	private final PaisRepositoryPort  paisRepositoryPort;

	@Override
	public Pais updatePais(Long id, Pais pais) {
		// TODO Auto-generated method stub
		
		return paisRepositoryPort.findById(id)
				.map(existingPais->{
					existingPais.setPais_name(pais.getPais_name());
					existingPais.setPais_cod(pais.getPais_cod());
					existingPais.setPais_zipcode(pais.getPais_zipcode());
					return paisRepositoryPort.save(existingPais);
					
				}).orElseThrow(()-> new PaisNotFoundException(id));
	}
	
	
}
