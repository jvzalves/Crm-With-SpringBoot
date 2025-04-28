package com.jvzalves.crm.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enterprise")
public class Enterprise {

	@Nonnull
	@Id
	private Long id;

	@OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
	private Set<Contact> contacts = new HashSet<>();

	@Column(name = "name_enterprise")
	private String name;
    
	@ManyToOne
	@JoinColumn(name = "responsible_id")
	private Responsible responsible;

	public Enterprise() {}

	public Enterprise(Long id, Set<Contact> contacts, String name, Responsible responsible) {
		this.id = id;
		this.contacts = contacts;
		this.name = name;
		this.responsible = responsible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts, id, name, responsible);
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
				&& Objects.equals(name, other.name) && Objects.equals(responsible, other.responsible);
	}
}