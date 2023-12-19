package com.agencia.models;       // a relacao de cliente com compra é @OneToMany pq um cliente pode ter varias compras

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;  //API COM SWEGGER O GABRIEL ACHA MAIS SIMPLES PRA NAO PRECISAR SE PREOCUPAR COM O FRONT END!!!!! AI NAO PRECIS FICAR INDO E VOLTANDO DO FRONT
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@Column(nullable = false, length = 200)
	private String nomeCliente;
	
	@Column(nullable = false, length = 11, unique = true)
	private String cpfCliente;
	
	@Column(nullable = false, length = 200)
	private String enderecoCliente;
	
	
	@Column(nullable = false, length = 16)
	private String telefoneCliente;
	
	@Column(nullable = false, length = 200)
	private String emailCliente;
	
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "cliente" , cascade = {CascadeType.ALL}) //aqui acho que é onetoone na vdd pq no meu modelo ta 1,1....
	private List<Compra> CompraDoCliente = new ArrayList<Compra>(); //um cliente pode ter varios destinos, por isso aqui pode ter uma llista de destinos. O cliente é UM para MUITOS destinOs, PARA MUITAS COMPRAS.


	public long getIdCliente() {
		return idCliente;
	}


	public List<Compra> getCompraDoCliente() {
		return CompraDoCliente;
	}


	public void setCompraDoCliente(List<Compra> compraDoCliente) {
		CompraDoCliente = compraDoCliente;
	}


	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public String getEnderecoCliente() {
		return enderecoCliente;
	}


	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}


	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}



}
	
	
