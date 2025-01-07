package com.jvzalves.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.services.ContactService;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = "/{id}")
	public ContactDTO findById(@PathVariable Long id){
		ContactDTO result = contactService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<ContactDTO> findAll(){
		List<ContactDTO> result = contactService.findAll();
		return result;
	}

}
