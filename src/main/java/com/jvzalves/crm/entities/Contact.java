package com.jvzalves.crm.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contact")
public class Contact {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "enterprise_id")
		private Enterprise enterprise;
	
		@Column(columnDefinition = "TEXT")
		private String fullName;
	
		@Column(columnDefinition = "TEXT")
		private String email;
	
		@ManyToOne
		@JoinColumn(name = "responsible_id") 
	    private Responsible responsible;

		private String url;
		private String linkedin;
		private String position;
		private String phone;

		public Contact () {}

		public Contact(Long id, Enterprise enterprise, String fullName, String email, String url, String linkedin, String position, String phone) {
			this.id = id;
			this.enterprise = enterprise;
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

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
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
			return Objects.hash(email, enterprise, fullName, id, linkedin, phone, position, url);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contact other = (Contact) obj;
			return Objects.equals(email, other.email) && Objects.equals(enterprise, other.enterprise)
					&& Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
					&& Objects.equals(linkedin, other.linkedin) && Objects.equals(phone, other.phone)
					&& Objects.equals(position, other.position) && Objects.equals(url, other.url);
		}
}               
 