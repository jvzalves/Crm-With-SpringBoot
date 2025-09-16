package com.jvzalves.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.repositories.ContactRepository;
import com.jvzalves.crm.repositories.EnterpriseRepository;

import exceptions.RequiredObjectIsNullNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private EnterpriseRepository enterpriseRepository;

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

	@Transactional(readOnly = true)
	public List<ContactDTO> findByName(String name) {
		List<Contact> result = contactRepository.findByName(name);
		return result.stream().map(x -> new ContactDTO(x)).toList();
	}

	@Transactional
	public ContactDTO createContact(@RequestBody ContactDTO dto) {
		if (dto == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}

		Enterprise enterprise = enterpriseRepository.findById(dto.getEnterpriseId())
				.orElseThrow(() -> new EntityNotFoundException("Enterprise not found"));

		Contact contact = new Contact();

		contact.setFullName(dto.getFullName());
		contact.setEmail(dto.getEmail());
		contact.setUrl(dto.getUrl());
		contact.setLinkedin(dto.getLinkedin());
		contact.setPhone(dto.getPhone());
		contact.setEnterprise(enterprise);

		Contact saved = contactRepository.save(contact);
		return new ContactDTO(saved);
	}

	@Transactional
	public ContactDTO updateContact(@RequestBody ContactDTO dto) {
		if (dto == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}

		Contact updateExistingContact = contactRepository.findById(dto.getId())
				.orElseThrow(() -> new RequiredObjectIsNullNotFoundException("Contact not found" + dto.getId()));

		updateExistingContact.setId(dto.getId());
		updateExistingContact.setFullName(dto.getFullName());
		updateExistingContact.setEmail(dto.getEmail());
		updateExistingContact.setUrl(dto.getUrl());
		updateExistingContact.setLinkedin(dto.getLinkedin());
		updateExistingContact.setPhone(dto.getPhone());

		Enterprise enterprise = enterpriseRepository.findById(dto.getEnterpriseId()).orElseThrow(
				() -> new RequiredObjectIsNullNotFoundException("Enterprise not found: " + dto.getEnterpriseId()));

		updateExistingContact.setEnterprise(enterprise);

		Contact saved = contactRepository.save(updateExistingContact);
		return new ContactDTO(saved);
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
