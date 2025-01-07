package com.jvzalves.crm.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.entities.Responsible;

public class ResponsibleDTO {
	
	private Long id;
	private String user;

	private Set<Enterprise> enterprises = new HashSet<>();
	private Set<Contact> contacts = new HashSet<>();
    
	public ResponsibleDTO () {}
	
	public ResponsibleDTO(Responsible entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Set<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(Set<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts, enterprises, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsibleDTO other = (ResponsibleDTO) obj;
		return Objects.equals(contacts, other.contacts) && Objects.equals(enterprises, other.enterprises)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}
	
}
