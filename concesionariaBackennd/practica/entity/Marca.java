package com.concesionaria.practica.entity;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marca")
public class Marca implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_marca;
	
	private String marca;
	
	private String descripcionMarca;
	
	public Marca() {}  

	public Marca(int idMarca, String marca, String descripcionMarca) {
		this.id_marca = idMarca;
		this.marca = marca;
		this.descripcionMarca = descripcionMarca;
	}
	

	
	public int getIdMarca() {
		return id_marca;  
	}

	public void setIdMarca(int idMarca) {
		this.id_marca = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}
	
	
	
	
}
