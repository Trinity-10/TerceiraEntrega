package com.agencia.repositories;   //issoné uma interface. Uma interface é como se fosse uma "máscara" para uma classe

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencia.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}