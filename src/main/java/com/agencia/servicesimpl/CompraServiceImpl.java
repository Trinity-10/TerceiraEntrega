package com.agencia.servicesimpl;  //COMPRA É MANYTONE

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.agencia.models.Compra;
import com.agencia.repositories.CompraRepository;
import com.agencia.services.CompraService;


@Service
public class CompraServiceImpl implements CompraService {


	
	@Autowired
	private CompraRepository  cos;
	

	@Override
	public List<Compra> GetAllCompras() {
		
		
		return cos.findAll();
	}

	@Override
	public Compra GetCompraById(Long idCompra) {
		
		return cos.findById(idCompra).orElseThrow(() -> new RuntimeException("Id: " + idCompra + "Não encontrado" )); 
	}

	@Override
	public Compra SaveCompra(Compra compra) {
		
		return cos.save(compra);
	}

	@Override
	public Compra UpdateCompra(Long idCompra, Compra CompraAtualizado) {
		Compra compraExistente = cos.findById(idCompra) .orElseThrow(() -> new RuntimeException("Id: " + idCompra + "Não encontrado" ));
		compraExistente.setValorCompra(CompraAtualizado.getValorCompra());
		compraExistente.setDescricaoCompra(CompraAtualizado.getDescricaoCompra());
	
		
		
		return cos.save(CompraAtualizado);
	}

	@Override
	public void DeleteCompra(Long idCompra) {
		
		 cos.deleteById(idCompra);
	}

	//@Override
	//public Void AddRelationship(Long idCompra, Long idCompra, Long idDestino) {
		
		//return null;
	//}

	@Override
	public List<Objects> findAllRels() {
		
		return null;
	}
}
