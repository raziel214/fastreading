package com.quimbaya.fastreading.ciudad.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quimbaya.fastreading.ciudad.aplication.service.CiudadService;
import com.quimbaya.fastreading.ciudad.domain.model.Ciudad;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {
	
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping
	public ResponseEntity <List<Ciudad>> fetchAllCiudad(){
		
		List<Ciudad> ciudad= ciudadService.fetchAll();
		return new ResponseEntity<>(ciudad,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Ciudad> createCiudad(@RequestBody Ciudad ciudad){
		
		Ciudad createCiudad=ciudadService.createCiudad(ciudad);
		return new ResponseEntity<>(createCiudad,HttpStatus.OK);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateCiudad(@PathVariable Long id,@RequestBody Ciudad ciudad)
	{		
		Ciudad updateCiudad= ciudadService.updateCiudad(id, ciudad);
		return new ResponseEntity<>(updateCiudad, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteCiudad(@PathVariable Long id)
	{
		boolean isDelete=ciudadService.deleteById(id);
		if(isDelete) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
