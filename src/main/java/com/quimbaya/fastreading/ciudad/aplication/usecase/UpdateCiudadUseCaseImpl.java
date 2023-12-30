package com.quimbaya.fastreading.ciudad.aplication.usecase;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.ciudad.domain.exception.CiudadNotFoundException;
import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.in.UpdateCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UpdateCiudadUseCaseImpl implements UpdateCiudadUseCase {

	private final CiudadRepositoryPort ciudadRepositoryPort;

	@Override
	public Ciudad updateCiudad(Long id, Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadRepositoryPort.findById(id)
				.map(existingCiudad->{
					existingCiudad.setName_ciudad(ciudad.getName_ciudad());
					existingCiudad.setCod_ciudad(ciudad.getCod_ciudad());
					existingCiudad.setZipcode(ciudad.getZipcode());
					existingCiudad.setPais_id(ciudad.getPais_id());
					
					return ciudadRepositoryPort.save(existingCiudad);
					
				}).orElseThrow(()-> new CiudadNotFoundException(id));
	}
	
	
}
