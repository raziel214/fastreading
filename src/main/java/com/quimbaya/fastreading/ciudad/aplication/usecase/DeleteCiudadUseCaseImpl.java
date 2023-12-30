package com.quimbaya.fastreading.ciudad.aplication.usecase;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.ciudad.domain.port.in.DeleteCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class DeleteCiudadUseCaseImpl implements DeleteCiudadUseCase {

	private final CiudadRepositoryPort ciudadRepositoryPort;

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return ciudadRepositoryPort.deleteById(id);
	}
	
	
	
}
