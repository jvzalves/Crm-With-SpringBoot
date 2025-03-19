package com.jvzalves.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.repositories.ContactRepository;

import exceptions.RequiredObjectIsNullNotFoundException;

@Service
public class ContactService {
   
	@Autowired
	private ContactRepository contactRepository;
	
	@Transactional(readOnly = true )
		public ContactDTO findById(Long id) {
			Contact result = contactRepository.findById(id).get();
			ContactDTO dto = new ContactDTO(result);
			return dto;
		}
	
	@Transactional(readOnly = true )
	public List <ContactDTO> findAll(){
		List<Contact> result = contactRepository.findAll();
		List<ContactDTO> dto = result.stream().map(x -> new ContactDTO(x)).toList();
		return dto;
	}

	@PostMapping
	@Transactional
	public ContactDTO createContact(@RequestBody Contact contact) {
		if (contact == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}
		try {
			Contact result = contactRepository.save(contact);
			ContactDTO dto = new ContactDTO(result);
			return dto;
		} catch (Exception e) {
			throw new RequiredObjectIsNullNotFoundException("Error creating contact");
		}
	}
}






