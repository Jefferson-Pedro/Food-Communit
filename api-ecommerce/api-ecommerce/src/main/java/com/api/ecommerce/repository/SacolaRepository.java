package com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ecommerce.model.Sacola;

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long>{
	
}
