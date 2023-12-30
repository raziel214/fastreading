package com.quimbaya.fastreading.ciudad.aplication.usecase;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.in.CreateCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class CreateCiudadUseCaseImpl implements CreateCiudadUseCase {

	private final CiudadRepositoryPort ciudadRepositoryPort;
	
	@Override
	public Ciudad createCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadRepositoryPort.save(ciudad);
	}

}
