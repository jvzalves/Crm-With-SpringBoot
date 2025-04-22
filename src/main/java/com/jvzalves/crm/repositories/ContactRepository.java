package com.jvzalves.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.crm.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {}


