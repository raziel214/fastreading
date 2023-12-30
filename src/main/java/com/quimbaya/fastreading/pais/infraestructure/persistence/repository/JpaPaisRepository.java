package com.quimbaya.fastreading.pais.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quimbaya.fastreading.pais.infraestructure.persistence.entity.PaisEntity;

public interface JpaPaisRepository extends JpaRepository <PaisEntity,Long>{

}
