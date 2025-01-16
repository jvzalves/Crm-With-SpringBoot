package com.jvzalves.crm.dto;

import java.util.Objects;

public class ResponsibleDTO {
	
	private Long id;
	private String user;
	
	public ResponsibleDTO () {}
	
	public ResponsibleDTO(Long id, String user) {
		this.id = id;
		this.user = user;
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
