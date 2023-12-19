package com.agencia.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.models.Compra;


@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	
	
	
}
