package com.quimbaya.fastreading.ciudad.aplication.service;

import java.util.List;
import java.util.Optional;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.in.CreateCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.in.DeleteCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.in.FetchAllCiudadUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.in.FindCiudadByIdUseCase;
import com.quimbaya.fastreading.ciudad.domain.port.in.UpdateCiudadUseCase;
import com.quimbaya.fastreading.user.aplication.service.UserService;
import com.quimbaya.fastreading.user.domain.port.in.CreatedUserUseCase;
import com.quimbaya.fastreading.user.domain.port.in.DeleteUserUsecase;
import com.quimbaya.fastreading.user.domain.port.in.FetchAllUserUseCase;
import com.quimbaya.fastreading.user.domain.port.in.FindByIdUserUsecase;
import com.quimbaya.fastreading.user.domain.port.in.LoginUserUseCase;
import com.quimbaya.fastreading.user.domain.port.in.UpdateUserUseCase;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CiudadService implements CreateCiudadUseCase, DeleteCiudadUseCase, FetchAllCiudadUseCase, FindCiudadByIdUseCase, UpdateCiudadUseCase {

	 private final CreateCiudadUseCase createCiudadUseCase;
	 private final DeleteCiudadUseCase deleteCiudadUseCase;
	 private final FetchAllCiudadUseCase fetchAllCiudadUseCase;
	 private final FindCiudadByIdUseCase findCiudadByIdUseCase;
	 private final UpdateCiudadUseCase updateCiudadUseCase;
	 

	@Override
	public Ciudad updateCiudad(Long id, Ciudad ciudad) {
		// TODO Auto-generated method stub
		return updateCiudadUseCase.updateCiudad(id, ciudad);
	}

	@Override
	public Optional<Ciudad> findById(Long id) {
		// TODO Auto-generated method stub
		return findCiudadByIdUseCase.findById(id);
	}

	@Override
	public List<Ciudad> fetchAll() {
		// TODO Auto-generated method stub
		return fetchAllCiudadUseCase.fetchAll();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return deleteCiudadUseCase.deleteById(id);
	}

	@Override
	public Ciudad createCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return createCiudadUseCase.createCiudad(ciudad);
	}
	 
	 
}
