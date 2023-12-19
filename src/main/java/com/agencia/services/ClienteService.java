package com.agencia.services;                 //ONE TO MANY

import java.util.List;
import java.util.Objects;

import com.agencia.models.Cliente;

public interface ClienteService {
	
	List<Cliente>GetAllClientes();
	
	Cliente GetClientById(Long idCliente);                    //contraol f muda os nomes
	
	Cliente SaveCliente(Cliente cliente);
	
	Cliente UpdateCliente(Long idCliente, Cliente ClienteAtualizado);
	
	void DeleteCliente (Long idCliente);
	
//	Void AddRelationship (Long idCliente, Long idCompra, Long idDestino);
	
	
	List<Objects>findAllRels();
	
	
	
	
	

}
