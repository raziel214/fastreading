package com.quimbaya.fastreading.pais.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quimbaya.fastreading.pais.domain.model.Pais;
import com.quimbaya.fastreading.pais.domain.port.out.PaisRepositoryPort;
import com.quimbaya.fastreading.pais.infraestructure.persistence.entity.PaisEntity;

@Component
public class JpaPaisRepositoryAdapter implements PaisRepositoryPort {
	
	
	
	@Autowired
	private JpaPaisRepository jpaPaisRepository;
	
		

	public JpaPaisRepositoryAdapter(JpaPaisRepository jpaPaisRepository) {
		this.jpaPaisRepository = jpaPaisRepository;
	}

	@Override
	public Pais save(Pais pais) {
		// TODO Auto-generated method stub
		PaisEntity entity = toEntity(pais);
		entity=jpaPaisRepository.save(entity);
		return toDomain(entity);
	}

	@Override
	public Optional<Pais> findById(Long id) {
		// TODO Auto-generated method stub
		return jpaPaisRepository.findById(id).map(this::toDomain);
	}

	@Override
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return jpaPaisRepository
				.findAll()
				.stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Pais> update(Pais pais) {
		// TODO Auto-generated method stub		
		if(jpaPaisRepository.existsById(pais.getPais_id())) {
			PaisEntity entityToUpdate = toEntity(pais);
			PaisEntity updatedEntity=jpaPaisRepository.save(entityToUpdate);
			return Optional.of(toDomain(updatedEntity));
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if(jpaPaisRepository.existsById(id)){
			jpaPaisRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	private Pais toDomain(PaisEntity entity) {
		return  new Pais(
				entity.getPaisId(),
				entity.getCodpais(),
				entity.getNamepais(),
				entity.getZipcodepais()
				);
	}
	
	private PaisEntity toEntity(Pais pais) {
		
		return new PaisEntity(
				pais.getPais_id(),
				pais.getPais_cod(),
				pais.getPais_name(),
				pais.getPais_zipcode()				
				);
	}
	

}
