package com.agencia.servicesimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.models.Destino;
import com.agencia.repositories.DestinoRepository;
import com.agencia.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService  {

	@Autowired    //descarta a necessidade de construtor
	private DestinoRepository dr;
	
	

	@Override
	public List<Destino> GetAllDestinos() {
		
		
		return dr.findAll();
	}

	@Override
	public Destino GetDestinoById(Long idDestino) {
		
		return dr.findById(idDestino).orElseThrow(() -> new RuntimeException("Id: " + idDestino + "Não encontrado" )); 
	}

	@Override
	public Destino SaveDestino(Destino destino) {
		
		return dr.save(destino);
	}

	@Override
	public Destino UpdateDestino(Long idDestino, Destino DestinoAtualizado) {
		Destino destinoExistente = dr.findById(idDestino) .orElseThrow(() -> new RuntimeException("Id: " + idDestino + "Não encontrado" ));
		destinoExistente.setHorarioDestino(DestinoAtualizado.getHorarioDestino());
		destinoExistente.setLocalDestino(DestinoAtualizado.getLocalDestino());
	
		
		
		return dr.save(DestinoAtualizado);
	}

	@Override
	public void DeleteDestino(Long idDestino) {
		
	 dr.deleteById(idDestino);
	}

	//@Override
	//public Void AddRelationship(Long idDestino, Long idCompra, Long idDestino) {
		
		//return null;
	//}

	@Override
	public List<Objects> findAllRels() {
		
		return null;
	}
	
	
}

