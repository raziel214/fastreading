package com.quimbaya.fastreading.role.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
	
	private Long rol_id;
    private String rol_name;
    private String rol_descripcion;
	
    
}
