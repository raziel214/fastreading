package com.quimbaya.fastreading.ciudad.infraestructure.persistence.entity;

import com.quimbaya.fastreading.pais.infraestructure.persistence.entity.PaisEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tm_ciudad") 
public class CiudadEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciudad_id")
    private Long ciudadId;
	


    @Column(name = "ciudad_nombre", length = 50)
    private String nombre;

    @Column(name = "ciudad_cod", length = 10)
    private String codCiudad;

    @Column(name = "zipcode", precision = 100)
    private Long zipCode;
    
    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "pais_id") 
    private PaisEntity pais;
}
