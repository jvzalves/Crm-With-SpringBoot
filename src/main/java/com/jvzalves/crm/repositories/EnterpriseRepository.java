package com.jvzalves.crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jvzalves.crm.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
	
	@Query("SELECT e FROM Enterprise e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<Enterprise> findByName(@Param("name") String name);
}


