package com.jvzalves.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.crm.dto.EnterpriseDTO;
import com.jvzalves.crm.services.EnterpriseService;

@RestController
@RequestMapping(value = "/enterprises")
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
}
