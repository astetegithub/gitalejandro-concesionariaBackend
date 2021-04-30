package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="auto")
public class Auto extends Vehiculo implements Serializable{
	
	private int numeroPuertas;
	private String combustible;
	  
	public Auto() {}

	public Auto(int idVehiculo, Double precio, String condicion, int anioCreacion, Double kilometraje, int stock,
			String descripcion, Marca marca, Double precioDescuento, int numeroPuertas, String combustible) {
		super(idVehiculo, precio, condicion, anioCreacion, kilometraje, stock, descripcion, marca, precioDescuento);
		this.numeroPuertas = numeroPuertas;
		this.combustible = combustible;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
