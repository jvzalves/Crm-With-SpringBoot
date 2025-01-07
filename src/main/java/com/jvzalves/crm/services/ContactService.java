package com.jvzalves.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.repositories.ContactRepository;

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
}
