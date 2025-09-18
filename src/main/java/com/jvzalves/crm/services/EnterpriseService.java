package com.jvzalves.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ContactDTO;
import com.jvzalves.crm.dto.EnterpriseDTO;
import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.repositories.EnterpriseRepository;

import exceptions.RequiredObjectIsNullNotFoundException;

@Service
public class EnterpriseService {

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Transactional(readOnly = true)
	public EnterpriseDTO findById(Long id) {
		Enterprise result = enterpriseRepository.findById(id).get();
		EnterpriseDTO dto = new EnterpriseDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<EnterpriseDTO> findAll() {
		List<Enterprise> result = enterpriseRepository.findAll();
		List<EnterpriseDTO> dto = result.stream().map(x -> new EnterpriseDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<EnterpriseDTO> findByName(String name) {
		List<Enterprise> result = enterpriseRepository.findByName(name);
		return result.stream().map(x -> new EnterpriseDTO(x)).toList();
	}

	@Transactional
	public EnterpriseDTO createEnterprise(@RequestBody Enterprise enterprise) {
		if (enterprise == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}
		try {
			Enterprise result = enterpriseRepository.save(enterprise);
			return new EnterpriseDTO(result);
		} catch (Exception e) {
			throw new RequiredObjectIsNullNotFoundException("Error add enterprise");
		}
	}

	@Transactional
	public EnterpriseDTO updateEnterprise(@RequestBody Enterprise enterprise) {
		if (enterprise == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not update enterprise");
		}

		try {
			Enterprise updateExistingEnterprise = enterpriseRepository.findById(enterprise.getId()).orElseThrow(
					() -> new RequiredObjectIsNullNotFoundException("Contact not found" + enterprise.getId()));

			updateExistingEnterprise.setId(enterprise.getId());
			updateExistingEnterprise.setName(enterprise.getName());

			Enterprise updateEnterprise = enterpriseRepository.save(updateExistingEnterprise);
			return new EnterpriseDTO(updateEnterprise);

		} catch (Exception e) {
			
		}
		throw new RequiredObjectIsNullNotFoundException("Error updating enterprise");
	}
	
	@Transactional
	public void deleteById(Long id) {
		Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
		if (enterprise.isPresent()) {
			enterpriseRepository.deleteById(id);
		} else {
			throw new RequiredObjectIsNullNotFoundException("enterprise not found for this id : " + id);
		}
	}
}
