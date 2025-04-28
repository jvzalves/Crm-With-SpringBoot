package com.jvzalves.crm.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_responsible")
public class Responsible {
    
	@Nonnull
	@Id
	private Long id;

	@Column(name = "responsible_user")
	private String user;
    
	@OneToMany(mappedBy = "responsible") 
	private Set<Enterprise> enterprises = new HashSet<>();
   
	@OneToMany(mappedBy = "responsible")
	private Set<Contact> contacts = new HashSet<>();
	
    public Responsible () {}

	public Responsible(Long id, String user, Set<Enterprise> enterprises, Set<Contact> contacts) {
		this.id = id;
		this.user = user;
		this.enterprises = enterprises;
		this.contacts = contacts;
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

	public Set<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(Set<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts, enterprises, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsible other = (Responsible) obj;
		return Objects.equals(contacts, other.contacts) && Objects.equals(enterprises, other.enterprises)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}
}
