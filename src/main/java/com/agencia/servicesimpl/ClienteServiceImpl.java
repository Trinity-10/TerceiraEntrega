package com.agencia.servicesimpl; //CLIENTE É ONETOMANY

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.models.Cliente;
import com.agencia.repositories.ClienteRepository;
import com.agencia.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired    //descarta a necessidade de construtor
	private ClienteRepository cr;
	
	

	@Override
	public List<Cliente> GetAllClientes() {
		
		
		return cr.findAll();
	}

	@Override
	public Cliente GetClientById(Long idCliente) {
		
		return cr.findById(idCliente).orElseThrow(() -> new RuntimeException("Id: " + idCliente + "Não encontrado" )); 
	}

	@Override
	public Cliente SaveCliente(Cliente cliente) {
		
		return cr.save(cliente);
	}

	@Override
	public Cliente UpdateCliente(Long idCliente, Cliente ClienteAtualizado) {
		Cliente clienteExistente = cr.findById(idCliente) .orElseThrow(() -> new RuntimeException("Id: " + idCliente + "Não encontrado" ));
		clienteExistente.setNomeCliente(ClienteAtualizado.getNomeCliente());
		clienteExistente.setCpfCliente(ClienteAtualizado.getCpfCliente());
		clienteExistente.setEnderecoCliente(ClienteAtualizado.getEnderecoCliente());
		clienteExistente.setTelefoneCliente(ClienteAtualizado.getTelefoneCliente());
		clienteExistente.setEmailCliente(ClienteAtualizado.getEmailCliente());
		
		
		return cr.save(ClienteAtualizado);
	}

	@Override
	public void DeleteCliente(Long idCliente) {
		
	 cr.deleteById(idCliente);
	}

	//@Override
	//public Void AddRelationship(Long idCliente, Long idCompra, Long idDestino) {
		
		//return null;
	//}

	@Override
	public List<Objects> findAllRels() {
		
		return null;
	}
	
}
	
	
	
	
	
