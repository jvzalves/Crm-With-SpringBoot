package com.jvzalves.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.entities.Responsible;
import com.jvzalves.crm.repositories.ContactRepository;
import com.jvzalves.crm.repositories.EnterpriseRepository;
import com.jvzalves.crm.repositories.ResponsibleRepository;

import exceptions.RequiredObjectIsNullNotFoundException;

@Service
public class ContactService {
   
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private ResponsibleRepository responsibleRepository;
	
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
	public ContactDTO createContact(@RequestBody ContactDTO dto) {
	    if (dto == null) {
	        throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
	    }
	    try {
	    	
	        Enterprise enterprise = null;
	        Responsible responsible = null;

	        if (dto.getEnterpriseId() != null) {
	            enterprise = enterpriseRepository.findById(dto.getEnterpriseId())
	                .orElseThrow(() -> new RuntimeException("Enterprise not found"));
	        }

	        if (dto.getResponsibleId() != null) {
	            responsible = responsibleRepository.findById(dto.getResponsibleId())
	                .orElseThrow(() -> new RuntimeException("Responsible not found"));
	        }
	        
	        Contact contact = new Contact();
	        contact.setFullName(dto.getFullName());
	        contact.setEmail(dto.getEmail());
	        contact.setPhone(dto.getPhone());
	        contact.setUrl(dto.getUrl());
	        contact.setLinkedin(dto.getLinkedin());
	        contact.setEnterprise(enterprise);
	        contact.setResponsible(responsible);

	        Contact result = contactRepository.save(contact);
	        return new ContactDTO(result);

	    } catch (Exception e) {
	        throw new RequiredObjectIsNullNotFoundException("Error creating contact");
	    }
	}
}






