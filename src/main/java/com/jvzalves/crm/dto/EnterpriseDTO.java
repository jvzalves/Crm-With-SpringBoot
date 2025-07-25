package com.jvzalves.crm.dto;

import java.util.Objects;

import com.jvzalves.crm.entities.Enterprise;

public class EnterpriseDTO {
	
	private Long id;
    private String name;
 
    public EnterpriseDTO () {}

	public EnterpriseDTO(Enterprise entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
}
