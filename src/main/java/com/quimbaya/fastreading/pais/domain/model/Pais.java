package com.quimbaya.fastreading.pais.domain.model;

import com.quimbaya.fastreading.role.domain.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	
	private Long pais_id;
	private String pais_cod;
	private String pais_name;
	private String pais_zipcode;

}
