package com.quimbaya.fastreading.ciudad.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quimbaya.fastreading.ciudad.infraestructure.persistence.entity.CiudadEntity;

public interface JpaCiudadRepository extends JpaRepository <CiudadEntity,Long> {

}
