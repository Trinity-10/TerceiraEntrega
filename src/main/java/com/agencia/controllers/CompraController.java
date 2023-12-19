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

import com.agencia.models.Compra;
import com.agencia.services.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	
	@Autowired	
	private CompraService cos;   // COS:COMPRA SERVICE NO MEU PROJETO

	@PostMapping("/savecompra")
	public Compra createCompra(@RequestBody Compra compra) {
	
		
		return cos.SaveCompra(compra);
	}
	
	@GetMapping("/allcompras")
	public List<Compra> getAllCompras(){
		
		return cos.GetAllCompras();
		
	}
	
	@GetMapping("/{idCompra}")
	public ResponseEntity<Compra> getCompraById(@PathVariable Long id){
		Compra compra = cos.GetCompraById(id);
		
		return ResponseEntity.ok(compra);
		
	}
	
	@PutMapping("/{idCompra}")
	public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compraUpdated){
		Compra compra = cos.GetCompraById(id);
	
		compra.setIdCompra(compraUpdated.getIdCompra());
		compra.setValorCompra(compraUpdated.getValorCompra());
		compra.setDescricaoCompra(compraUpdated.getDescricaoCompra());
		
		return ResponseEntity.ok(compra);
		

	}
	
	@DeleteMapping("/{idCompra}") 
	public void deleteCompra(@PathVariable Long id) {
		cos.DeleteCompra(id);
	
	
	}
	
}
