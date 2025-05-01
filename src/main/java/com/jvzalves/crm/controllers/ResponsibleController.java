package com.jvzalves.crm.controllers;

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

import com.jvzalves.crm.dto.ResponsibleDTO;
import com.jvzalves.crm.entities.Responsible;
import com.jvzalves.crm.services.ResponsibleService;

@RestController	
@RequestMapping(value = "/responsibles")
public class ResponsibleController {
	
	@Autowired
	private ResponsibleService responsibleService;
	
	@GetMapping(value = "/{id}")
	public ResponsibleDTO findById(@PathVariable Long id){
		ResponsibleDTO result = responsibleService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<ResponsibleDTO> findAll(){
		List<ResponsibleDTO> result = responsibleService.findAll();
		return result;
	}
	
	@PostMapping
	public ResponseEntity<ResponsibleDTO> createResponsible(@RequestBody Responsible responsible){
		ResponsibleDTO dto = responsibleService.createResponsible(responsible);
		   return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponsibleDTO> updateResponsible(@RequestBody Responsible responsible){
		ResponsibleDTO dto = responsibleService.updateResponsible(responsible);
		return new ResponseEntity<>(dto, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		responsibleService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
