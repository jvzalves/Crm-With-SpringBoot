package com.jvzalves.crm.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enterprise")
public class Enterprise {

	@Nonnull
	@Id
	private Long id;

	@OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
	private List<Contact> contacts = new ArrayList<>();

	@Column(name = "name_enterprise")
	private String name;

	public Enterprise() {}

	public Enterprise(Long id, List<Contact> contacts, String name) {
		this.id = id;
		this.contacts = contacts;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enterprise other = (Enterprise) obj;
		return Objects.equals(contacts, other.contacts) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

}