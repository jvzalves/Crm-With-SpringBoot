package com.jvzalves.crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jvzalves.crm.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("SELECT c FROM Contact c WHERE LOWER(c.fullName) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<Contact> findByName(@Param("name") String name);

}

