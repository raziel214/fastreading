package com.quimbaya.fastreading.pais.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quimbaya.fastreading.pais.aplicacion.service.PaisService;
import com.quimbaya.fastreading.pais.domain.model.Pais;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

	@Autowired
	private PaisService paisService;
	
	@GetMapping
    public ResponseEntity<List<Pais>> fetchAllPais(){
		
		List<Pais> pais=paisService.fetchAll();
		return new ResponseEntity<>(pais, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity <Pais> createPais(@RequestBody Pais pais){
		
		Pais createPais=paisService.createPais(pais);
		return new ResponseEntity<>(createPais, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity <?> updatePais(@PathVariable Long id,@RequestBody Pais pais){
		
		Pais updatePais=paisService.updatePais(id,pais);
		return new ResponseEntity<>(updatePais, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> deletePais(@PathVariable Long id)
	{
		boolean isDelete=paisService.deleteById(id);
		if(isDelete) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
