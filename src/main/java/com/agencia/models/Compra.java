package com.agencia.models;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompra; 
	
	@Column (length = 50) 
	private BigDecimal valorCompra;  //name
	
	@Column (length = 200)
	private String descricaoCompra;  //age
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cliente")  
	private Cliente cliente; 

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="compra")  
	private Compra compra; 
	
	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getDescricaoCompra() {
		return descricaoCompra;
	}

	public void setDescricaoCompra(String descricaoCompra) {
		this.descricaoCompra = descricaoCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}