package com.jvzalves.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.crm.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{

}
