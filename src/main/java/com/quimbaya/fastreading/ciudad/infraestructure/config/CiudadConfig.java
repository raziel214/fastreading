package com.quimbaya.fastreading.ciudad.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quimbaya.fastreading.ciudad.aplication.service.CiudadService;
import com.quimbaya.fastreading.ciudad.aplication.usecase.CreateCiudadUseCaseImpl;
import com.quimbaya.fastreading.ciudad.aplication.usecase.DeleteCiudadUseCaseImpl;
import com.quimbaya.fastreading.ciudad.aplication.usecase.FetchAllCiudadUseCaseImpl;
import com.quimbaya.fastreading.ciudad.aplication.usecase.FindCiudadByIdUseCaseImpl;
import com.quimbaya.fastreading.ciudad.aplication.usecase.UpdateCiudadUseCaseImpl;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;
import com.quimbaya.fastreading.ciudad.infraestructure.persistence.repository.JpaCiudadRepositoryAdapter;

@Configuration
public class CiudadConfig {
	
	@Bean
	public CiudadService ciudadService(CiudadRepositoryPort ciudadRepositoryPort) 
	{	
		return new CiudadService(
				new CreateCiudadUseCaseImpl(ciudadRepositoryPort),
				new DeleteCiudadUseCaseImpl(ciudadRepositoryPort),
				new FetchAllCiudadUseCaseImpl(ciudadRepositoryPort),
				new FindCiudadByIdUseCaseImpl(ciudadRepositoryPort),
				new UpdateCiudadUseCaseImpl(ciudadRepositoryPort)				
				);
	}
	
	@Bean
	public CiudadRepositoryPort ciudadRepositoryPort(JpaCiudadRepositoryAdapter jpaCiudadRepositoryAdapter) {
		
		return jpaCiudadRepositoryAdapter;
	}
	

}
