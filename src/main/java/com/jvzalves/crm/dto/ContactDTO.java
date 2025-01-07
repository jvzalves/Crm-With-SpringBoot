package com.jvzalves.crm.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.jvzalves.crm.entities.Contact;
import com.jvzalves.crm.entities.Enterprise;
import com.jvzalves.crm.entities.Responsible;

public class ContactDTO {
  
	private Long id;
	private Enterprise enterprise;
    private Responsible responsible;
	private String fullName;
	private String email;
	private String url;
	private String linkedin;
	private String phone;

	public ContactDTO () {}

	public ContactDTO(Contact entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enterprise, fullName, id, linkedin, phone, responsible, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDTO other = (ContactDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(enterprise, other.enterprise)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
				&& Objects.equals(linkedin, other.linkedin) && Objects.equals(phone, other.phone)
				&& Objects.equals(responsible, other.responsible) && Objects.equals(url, other.url);
	}
}
