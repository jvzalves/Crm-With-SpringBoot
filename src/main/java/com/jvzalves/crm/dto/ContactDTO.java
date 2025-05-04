package com.jvzalves.crm.dto;

import java.util.Objects;

import com.jvzalves.crm.entities.Contact;

public class ContactDTO {

	private Long id;
	private Long enterpriseId;
	private String fullName;
	private String email;
	private String url;
	private String linkedin;
	private String phone;

	public ContactDTO() {	}

	public ContactDTO(Contact entity) {
		this.id = entity.getId();
		this.enterpriseId = entity.getEnterprise().getId();
		this.fullName = entity.getFullName();
		this.email = entity.getEmail();
		this.url = entity.getUrl();
		this.linkedin = entity.getLinkedin();
		this.phone = entity.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
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
		return Objects.hash(email, enterpriseId, fullName, id, linkedin, phone, url);
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
		return Objects.equals(email, other.email) && Objects.equals(enterpriseId, other.enterpriseId)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
				&& Objects.equals(linkedin, other.linkedin) && Objects.equals(phone, other.phone)
				&& Objects.equals(url, other.url);
	}

}