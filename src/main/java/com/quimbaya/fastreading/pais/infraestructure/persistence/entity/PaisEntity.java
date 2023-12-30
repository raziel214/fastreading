package com.quimbaya.fastreading.pais.infraestructure.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tm_pais") 
public class PaisEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long paisId;
	
	@Column(name = "pais_cod")
    private String codpais;
	
	@Column(name = "pais_name")
    private String namepais;
	
	@Column(name = "pais_zipcode")
    private String zipcodepais;

}
