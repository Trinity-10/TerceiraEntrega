package com.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.models.Cliente;
import com.agencia.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


	@Autowired	
	private ClienteService cs;   //CS: COURSE SERVICE NO DO GABRIEL, CLIENTE SERVICE NO MEU

	@PostMapping("/savecliente")
	public Cliente createCLiente(@RequestBody Cliente cliente) {
	
		
		return cs.SaveCliente(cliente);
	}
	
	@GetMapping("/allclientes")
	public List<Cliente> getAllClientes(){
		
		return cs.GetAllClientes();
		
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> getClienteby(@PathVariable Long id){
		Cliente cliente = cs.GetClientById(id);
		
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUpdated){
		Cliente cliente = cs.GetClientById(id);
		
		cliente.setIdCliente(clienteUpdated.getIdCliente());
		cliente.setNomeCliente(clienteUpdated.getNomeCliente());
		cliente.setCpfCliente(clienteUpdated.getCpfCliente());
		cliente.setEnderecoCliente(clienteUpdated.getEnderecoCliente());
		cliente.setTelefoneCliente(clienteUpdated.getTelefoneCliente());
		cliente.setEmailCliente(clienteUpdated.getEmailCliente());
		
		return ResponseEntity.ok(cliente);
		
	
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		cs.DeleteCliente(id);
	
	}	
}
