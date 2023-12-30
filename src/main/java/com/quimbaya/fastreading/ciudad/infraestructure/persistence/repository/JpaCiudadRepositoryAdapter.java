package com.quimbaya.fastreading.ciudad.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;
import com.quimbaya.fastreading.ciudad.domain.port.out.CiudadRepositoryPort;
import com.quimbaya.fastreading.ciudad.infraestructure.persistence.entity.CiudadEntity;
import com.quimbaya.fastreading.pais.infraestructure.persistence.entity.PaisEntity;
import com.quimbaya.fastreading.pais.infraestructure.persistence.repository.JpaPaisRepository;

@Component
public class JpaCiudadRepositoryAdapter implements CiudadRepositoryPort{
	
	@Autowired
	private JpaCiudadRepository jpaCiudadRepository;
	@Autowired
	private JpaPaisRepository jpaPaisRepository;
	
	

	public JpaCiudadRepositoryAdapter(JpaCiudadRepository jpaCiudadRepository, JpaPaisRepository jpaPaisRepository) {
		this.jpaCiudadRepository = jpaCiudadRepository;
		this.jpaPaisRepository = jpaPaisRepository;
	}

	@Override
	public Ciudad save(Ciudad ciudad) {
		// TODO Auto-generated method stub
		CiudadEntity entity= toEntity(ciudad);
		entity=jpaCiudadRepository.save(entity);
		return toDomain(entity); 
	}

	@Override
	public Optional<Ciudad> findById(Long id) {
		// TODO Auto-generated method stub
		return jpaCiudadRepository.findById(id).map(this::toDomain);
	}

	@Override
	public List<Ciudad> findAll() {
		// TODO Auto-generated method stub
		return jpaCiudadRepository.findAll()
				.stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Ciudad> update(Ciudad ciudad) {
		// TODO Auto-generated method stub
		if(jpaCiudadRepository.existsById(ciudad.getCiudad_id())) {
			CiudadEntity entityToUpdate=toEntity(ciudad);
			CiudadEntity updatedEntity=jpaCiudadRepository.save(entityToUpdate);
			return Optional.of(toDomain(updatedEntity));
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if(jpaCiudadRepository.existsById(id)) {
			jpaCiudadRepository.deleteById(id);
			return true;
			
		}
		return false;
	}
	
	
	private Ciudad toDomain(CiudadEntity entity) {
		
		return new Ciudad(
				entity.getCiudadId(),
				entity.getNombre(),
				entity.getCodCiudad(),
				entity.getZipCode(),
				entity.getPais().getPaisId());
		
	}
	
	
	private CiudadEntity toEntity(Ciudad ciudad) {
		
		Optional <PaisEntity> optionalPaisEntity= jpaPaisRepository.findById(ciudad.getCiudad_id());
		if (!optionalPaisEntity.isPresent()) {
	        throw new IllegalArgumentException("No Pais found with ID: " + ciudad.getPais_id());
	    }
		PaisEntity ciudadPaisEntity=optionalPaisEntity.get();
		return new CiudadEntity(
				ciudad.getCiudad_id(),
				ciudad.getName_ciudad(),
				ciudad.getCod_ciudad(),
				ciudad.getZipcode(),
				ciudadPaisEntity
				);
	}
}
