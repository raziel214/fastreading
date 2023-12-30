package com.quimbaya.fastreading.ciudad.domain.model;

import com.quimbaya.fastreading.pais.domain.model.Pais;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

	private Long   ciudad_id;
	private String cod_ciudad;
	private String name_ciudad;
	private Long   zipcode;
	private Long   pais_id;
}
