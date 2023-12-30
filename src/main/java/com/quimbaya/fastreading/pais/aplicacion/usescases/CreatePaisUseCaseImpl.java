package com.quimbaya.fastreading.pais.aplicacion.usescases;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.in.CreatePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;
import com.quimbaya.fastreading.role.application.usecases.CreatedRoleUseCaseImpl;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Service
public class CreatePaisUseCaseImpl implements CreatePaisUseCase {

	private final PaisRepositoryPort  paisRepositoryPort;

	@Override
	public Pais createPais(Pais pais) {
		// TODO Auto-generated method stub
		return paisRepositoryPort.save(pais);
	}
}
