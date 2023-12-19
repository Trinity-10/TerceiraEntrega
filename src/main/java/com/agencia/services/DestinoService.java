package com.agencia.services;            //ONE TO MANY

import java.util.List;

import java.util.Objects;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.models.Destino;

public interface DestinoService  {

	List<Destino>GetAllDestinos();
	
	Destino GetDestinoById(Long idDestino);                    //control f muda os nomes
	
	Destino SaveDestino(Destino destino);
	
	Destino UpdateDestino(Long idDestino, Destino DestinoAtualizado);
	
	void DeleteDestino (Long idDestino);
	
	// Void AddRelationship (Long idDestino, Long idCompra, Long idDestino);
	
	
	List<Objects>findAllRels();
	
	
}
