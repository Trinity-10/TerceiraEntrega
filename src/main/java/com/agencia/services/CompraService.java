package com.agencia.services;                     // COMPRA É MANY TO ONE

import java.util.List;
import java.util.Objects;


import com.agencia.models.Compra;

public interface CompraService {
	
	
	List<Compra>GetAllCompras();
	
	Compra GetCompraById(Long idCompra);                    //control f muda os nomes
	
	Compra SaveCompra(Compra compra);
	
	Compra UpdateCompra(Long idCompra, Compra CompraAtualizado);
	
	void DeleteCompra (Long idCompra);

	List<Objects> findAllRels();
	
//	Void AddRelationship (Long idCompra, Long idCompra, Long idCompra);
	
	
	

}
