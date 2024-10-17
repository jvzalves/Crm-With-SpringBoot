package com.jvzalves.crm.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_responsible")
public class Responsible {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "responsible_user")
	private String user;
    
	@OneToMany(mappedBy = "responsible")
    private List<Enterprise> enterprises;

    @OneToMany(mappedBy = "responsible")
    private List<Contacts> contacts;
}
