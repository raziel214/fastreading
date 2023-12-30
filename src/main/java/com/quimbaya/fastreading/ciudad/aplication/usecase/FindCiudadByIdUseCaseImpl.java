package com.quimbaya.fastreading.ciudad.aplication.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.in.FindCiudadByIdUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Service
public class FindCiudadByIdUseCaseImpl implements FindCiudadByIdUseCase {
	
	private final CiudadRepositoryPort ciudadRepositoryPort;

	@Override
	public Optional<Ciudad> findById(Long id) {
		// TODO Auto-generated method stub
		return ciudadRepositoryPort.findById(id);
	}
	
	
}
