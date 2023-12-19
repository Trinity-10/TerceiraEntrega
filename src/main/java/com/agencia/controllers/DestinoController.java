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


import com.agencia.models.Destino;
import com.agencia.services.DestinoService;

@RestController
@RequestMapping("/destinos")
public class DestinoController {


	@Autowired	
	private DestinoService ds;   //destino service

	@PostMapping("/savedestino")
	public Destino createDestino(@RequestBody Destino destino) {
	
		
		return ds.SaveDestino(destino);
	}
	
	@GetMapping("/alldestinos")
	public List<Destino> getAllDestinos(){
		
		return ds.GetAllDestinos();
		
	}
	
	@GetMapping("/{idDestino}")
	public ResponseEntity<Destino> getDestinobyId (@PathVariable Long id){
		Destino destino = ds.GetDestinoById(id);
		
		return ResponseEntity.ok(destino);
	}
	
	@PutMapping("/{idDestino}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoUpdated){
		Destino destino = ds.GetDestinoById(id);
		
		destino.setHorarioDestino(destinoUpdated.getHorarioDestino());
		destino.setLocalDestino(destinoUpdated.getLocalDestino());
		
		
		ds.SaveDestino(destino);
		
		return ResponseEntity.ok(destino);
		
	}
	
	@DeleteMapping("/{idDestino}")
	public void deleteDestino(@PathVariable Long id) {
		ds.DeleteDestino(id);
		
	}
	
}