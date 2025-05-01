package com.jvzalves.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.crm.dto.ResponsibleDTO;
import com.jvzalves.crm.entities.Responsible;
import com.jvzalves.crm.repositories.ResponsibleRepository;

import exceptions.RequiredObjectIsNullNotFoundException;

@Service
public class ResponsibleService {
    
	@Autowired
	private ResponsibleRepository responsibleRepository;
	
	@Transactional(readOnly = true)
	public ResponsibleDTO findById(Long id) {
		Responsible result = responsibleRepository.findById(id).get();
		return new  ResponsibleDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public List<ResponsibleDTO> findAll() {
		List<Responsible> result = responsibleRepository.findAll();
		List<ResponsibleDTO> dto = result.stream().map(x -> new ResponsibleDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public ResponsibleDTO createResponsible(@RequestBody Responsible responsible) {
		if (responsible == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
		}
		try {
			Responsible result = responsibleRepository.save(responsible);
			return new ResponsibleDTO(result);
		} catch (Exception e) {
			throw new RequiredObjectIsNullNotFoundException("Error add responsible");
		}
	}
	
	@Transactional
	public ResponsibleDTO updateResponsible(@RequestBody Responsible responsible) {
		if (responsible == null) {
			throw new RequiredObjectIsNullNotFoundException("It is not update enterprise");
		}

		try {
			Responsible updateExistingResponsible = responsibleRepository.findById(responsible.getId()).orElseThrow(
					() -> new RequiredObjectIsNullNotFoundException("Contact not found" + responsible.getId()));

			updateExistingResponsible.setId(responsible.getId());
			updateExistingResponsible.setUser(responsible.getUser());
		    

			Responsible updateResponsible = responsibleRepository.save(updateExistingResponsible);
			return new ResponsibleDTO(updateResponsible);

		} catch (Exception e) {
			
		}
		throw new RequiredObjectIsNullNotFoundException("Error updating enterprise");
	}
	
	@Transactional
	public void deleteById(Long id) {
		Optional<Responsible> responsible = responsibleRepository.findById(id);
		if (responsible.isPresent()) {
			responsibleRepository.deleteById(id);
		} else {
			throw new RequiredObjectIsNullNotFoundException("enterprise not found for this id : " + id);
		}
	}
	
}
