package com.quimbaya.fastreading.ciudad.aplication.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.in.FetchAllCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FetchAllCiudadUseCaseImpl implements FetchAllCiudadUseCase {
	
	private final CiudadRepositoryPort ciudadRepositoryPort;

	@Override
	public List<Ciudad> fetchAll() {
		// TODO Auto-generated method stub
		return ciudadRepositoryPort.findAll()
				.stream()
				.map(this::convertCiudadToDomain)
				.collect(Collectors.toList());
	}
	
	
	
	private Ciudad convertCiudadToDomain (Ciudad ciudadFromRepo) {
		return ciudadFromRepo;
	}

}
