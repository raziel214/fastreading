package com.quimbaya.fastreading.pais.aplicacion.usescases;

import org.springframework.stereotype.Service;

import com.quimbaya.fastreading.pais.domain.port.in.DeletePaisUseCase;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;
import com.quimbaya.fastreading.role.application.usecases.CreatedRoleUseCaseImpl;
import com.quimbaya.fastreading.role.domain.port.out.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Service
public class DeletePaisUsecaseImpl implements DeletePaisUseCase{

	private final PaisRepositoryPort paisRepositoryPort;

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return paisRepositoryPort.deleteById(id);
	}  
}
