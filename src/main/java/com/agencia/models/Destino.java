package com.agencia.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;


@Entity    ///id local horario

public class Destino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDestino;
	
	@Column (length = 50)
	private String localDestino;
	
	@Column (length = 50)
	@DateTimeFormat (iso=ISO.DATE)
	private Date horarioDestino;
	
	
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "destino" , cascade = {CascadeType.ALL}) //aqui acho que é onetoone na vdd pq no meu modelo ta 1,1....
	private List<Compra> DestinoDaCompra = new ArrayList<Compra>();

	public long getIdDestino() {
		return idDestino;
	}


	public List<Compra> getDestinoDaCompra() {
		return DestinoDaCompra;
	}


	public void setDestinoDaCompra(List<Compra> destinoDaCompra) {
		DestinoDaCompra = destinoDaCompra;
	}


	public void setIdDestino(long idDestino) {
		this.idDestino = idDestino;
	}


	public String getLocalDestino() {
		return localDestino;
	}


	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}


	public Date getHorarioDestino() {
		return horarioDestino;
	}


	public void setHorarioDestino(Date horarioDestino) {
		this.horarioDestino = horarioDestino;
	}

	
	
}
