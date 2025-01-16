package com.jvzalves.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.crm.dto.EnterpriseDTO;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.repositories.EnterpriseRepository;

@Service
public class EnterpriseService {
  
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Transactional(readOnly = true )
		public EnterpriseDTO findById(Long id) {
			Enterprise result = enterpriseRepository.findById(id).get();
			EnterpriseDTO dto = new EnterpriseDTO(result);
			return dto;
		}
	
	@Transactional(readOnly = true )
	public List <EnterpriseDTO> findAll(){
		List<Enterprise> result = enterpriseRepository.findAll();
		List<EnterpriseDTO> dto = result.stream().map(x -> new EnterpriseDTO(x)).toList();
		return dto;
	}
}
