package com.jvzalves.crm.dto;

import java.util.Objects;

import com.jvzalves.crm.entities.Enterprise;

public class EnterpriseDTO {
	
	private Long id;
    private Long responsibleId;
    private String name;
 
    public EnterpriseDTO () {}

	public EnterpriseDTO(Enterprise entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.responsibleId = (entity.getResponsible() != null) ? entity.getResponsible().getId() : null;
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

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, responsibleId);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(responsibleId, other.responsibleId);
	}
}
