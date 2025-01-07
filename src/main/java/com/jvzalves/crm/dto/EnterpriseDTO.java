package com.jvzalves.crm.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.entities.Responsible;

public class EnterpriseDTO {
    
	private Long id;
	private String name;
	private Responsible responsible;
	private Set<Contact> contacts = new HashSet<>();

	public EnterpriseDTO() {}

	public EnterpriseDTO(Enterprise entity) {
		BeanUtils.copyProperties(entity, this);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts, id, name, responsible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnterpriseDTO other = (EnterpriseDTO) obj;
		return Objects.equals(contacts, other.contacts) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(responsible, other.responsible);
	}
}
