package com.jvzalves.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.repositories.ContactRepository;

import exceptions.RequiredObjectIsNullNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly = true)
	public ContactDTO findById(Long id) {
		Contact result = contactRepository.findById(id).get();
		ContactDTO dto = new ContactDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<ContactDTO> findAll() {
		List<Contact> result = contactRepository.findAll();
		List<ContactDTO> dto = result.stream().map(x -> new ContactDTO(x)).toList();
		return dto;
	}

	@Transactional
	public ContactDTO createContact(@RequestBody Contact contact) {
		if (contact == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}
		try {
			Contact result = contactRepository.save(contact);
			return new ContactDTO(result);
		} catch (Exception e) {
			throw new RequiredObjectIsNullNotFoundException("Error creating contact");
		}
	}
    
	@Transactional
	public ContactDTO updateContact(@RequestBody Contact contact) {
		if (contact == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to apdate to contact");
		}

		try {

			Contact updateExistingContact = contactRepository.findById(contact.getId()).orElseThrow(
					() -> new RequiredObjectIsNullNotFoundException("Contact not found" + contact.getId()));

			updateExistingContact.setEmail(contact.getEmail());
			updateExistingContact.setFullName(contact.getFullName());
			updateExistingContact.setUrl(contact.getUrl());
			updateExistingContact.setLinkedin(contact.getLinkedin());
			updateExistingContact.setPhone(contact.getPhone());
			updateExistingContact.setResponsible(contact.getResponsible());
			updateExistingContact.setEnterprise(contact.getEnterprise());

			Contact updateContact = contactRepository.save(updateExistingContact);
			return new ContactDTO(updateContact);

		} catch (Exception e) {
			throw new RequiredObjectIsNullNotFoundException("Error updating contact");
		}
	}
	
	@Transactional
	public void deleteById(Long id) {
		Optional<Contact> contact = contactRepository.findById(id);
		if (contact.isPresent()) {
			contactRepository.deleteById(id);
		} else {
			throw new RequiredObjectIsNullNotFoundException("contact not found for this id : " + id);
		}
	}
}

