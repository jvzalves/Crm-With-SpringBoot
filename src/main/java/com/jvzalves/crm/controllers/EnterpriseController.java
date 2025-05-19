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

import com.jvzalves.crm.dto.EnterpriseDTO;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.services.EnterpriseService;

@RestController
@RequestMapping(value = "/api/v1/enterprises")
public class EnterpriseController {
	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping(value = "/{id}")
	public EnterpriseDTO findById(@PathVariable Long id){
		EnterpriseDTO result = enterpriseService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<EnterpriseDTO> findAll(){
		List<EnterpriseDTO> result = enterpriseService.findAll();
		return result;
	}
	
	@PostMapping
	public ResponseEntity<EnterpriseDTO> createEnterprise(@RequestBody Enterprise enterprise){
		EnterpriseDTO dto = enterpriseService.createEnterprise(enterprise);
		   return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<EnterpriseDTO> updateEnterprise(@RequestBody Enterprise enterprise){
		EnterpriseDTO dto = enterpriseService.updateEnterprise(enterprise);
		return new ResponseEntity<>(dto, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		enterpriseService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
