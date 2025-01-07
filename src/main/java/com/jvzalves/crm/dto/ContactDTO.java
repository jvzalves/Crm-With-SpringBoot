package com.jvzalves.crm.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.jvzalves.crm.entities.Contact;

public class ContactDTO {
  
	private Long id;
	private String nameEnterprise;
    private String nameResponsible;
	private String fullName;
	private String email;
	private String url;
	private String linkedin;
	private String phone;

	public ContactDTO () {}

	public ContactDTO(Contact entity) {
		BeanUtils.copyProperties(entity, this);
		this.nameEnterprise = (entity.getEnterprise() != null) ? entity.getEnterprise().getName() : null;
	    this.nameResponsible = (entity.getResponsible() != null) ? entity.getResponsible().getUser() : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEnterprise() {
		return nameEnterprise;
	}

	public void setNameEnterprise(String nameEnterprise) {
		this.nameEnterprise = nameEnterprise;
	}

	public String getNameResposible() {
		return nameResponsible;
	}

	public void setNameResposible(String nameResposible) {
		this.nameResponsible = nameResposible;
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
		return Objects.hash(email, fullName, id, linkedin, nameEnterprise, nameResponsible, phone, url);
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
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(id, other.id) && Objects.equals(linkedin, other.linkedin)
				&& Objects.equals(nameEnterprise, other.nameEnterprise)
				&& Objects.equals(nameResponsible, other.nameResponsible) && Objects.equals(phone, other.phone)
				&& Objects.equals(url, other.url);
	}

}