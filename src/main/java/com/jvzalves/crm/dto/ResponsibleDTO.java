package com.jvzalves.crm.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.jvzalves.crm.entities.Responsible;

public class ResponsibleDTO {
	
	private Long id;
	private String user;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(id, user);
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
		return Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}
}
