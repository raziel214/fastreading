package com.quimbaya.fastreading.pais.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quimbaya.fastreading.pais.aplicacion.service.PaisService;
import com.quimbaya.fastreading.pais.aplicacion.usescases.CreatePaisUseCaseImpl;
import com.quimbaya.fastreading.pais.aplicacion.usescases.DeletePaisUsecaseImpl;
import com.quimbaya.fastreading.pais.aplicacion.usescases.FetchAllPaisUseCaseImpl;
import com.quimbaya.fastreading.pais.aplicacion.usescases.FindPaisByIdUsecaseImpl;
import com.quimbaya.fastreading.pais.aplicacion.usescases.UpdatePaisUseCaseImpl;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;
import com.quimbaya.fastreading.pais.infraestructure.persistence.repository.JpaPaisRepositoryAdapter;

@Configuration
public class PaisConfig {
	
	@Bean
	public PaisService paisService(PaisRepositoryPort paisRepositoryPort) {
		
		return new PaisService(
				new CreatePaisUseCaseImpl(paisRepositoryPort),
				new DeletePaisUsecaseImpl(paisRepositoryPort),
				new FetchAllPaisUseCaseImpl(paisRepositoryPort),
				new FindPaisByIdUsecaseImpl(paisRepositoryPort),
				new UpdatePaisUseCaseImpl(paisRepositoryPort)
				);
	}
	

	@Bean
	public PaisRepositoryPort paisRepositoryPort(JpaPaisRepositoryAdapter jpaPaisRepositoryAdapter) {
		return jpaPaisRepositoryAdapter;
	}
	
}
