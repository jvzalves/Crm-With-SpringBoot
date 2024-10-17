package com.jvzalves.crm.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contacts")
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;
	
    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Responsible responsible;
	
	private String fullName;
    private String email;
	private String url;
	private String linkedin;
	private String position;
	private String phone;
    
	public Contacts () {}

	public Contacts(Long id, String fullName, String email, String url, String linkedin, String position, String phone) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.url = url;
		this.linkedin = linkedin;
		this.position = position;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, id, linkedin, phone, position, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(id, other.id) && Objects.equals(linkedin, other.linkedin)
				&& Objects.equals(phone, other.phone) && Objects.equals(position, other.position)
				&& Objects.equals(url, other.url);
	}

}
