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

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.services.ContactService;

@RestController
@RequestMapping(value = "/api/v1/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping(value = "/{id}")
	public ContactDTO findById(@PathVariable Long id) {
		ContactDTO result = contactService.findById(id);
		return result;
	}

	@GetMapping
	public List<ContactDTO> findAll() {
		List<ContactDTO> result = contactService.findAll();
		return result;
	}

	@GetMapping(value = "/name/{name}")
	public List<ContactDTO> findByName(@PathVariable String name) {
	     List <ContactDTO> result = contactService.findByName(name);
	     return result;
	}

	@PostMapping
	public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO dto) {
		ContactDTO contactDTO = contactService.createContact(dto);
		return new ResponseEntity<>(contactDTO, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO dto) {
		ContactDTO contactDTO = contactService.updateContact(dto);
		return new ResponseEntity<>(contactDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		contactService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
