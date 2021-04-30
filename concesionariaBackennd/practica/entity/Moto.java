package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="moto")
public class Moto extends Vehiculo implements Serializable{
	
	@Column(nullable = true)
	private int cilindrada;
	
	public Moto() {}


	public Moto(int idVehiculo, Double precio, String condicion, int anioCreacion, Double kilometraje, int stock,
			String descripcion, Marca marca, Double precioDescuento, int cilindrada) {
		super(idVehiculo, precio, condicion, anioCreacion, kilometraje, stock, descripcion, marca, precioDescuento);
		this.cilindrada = cilindrada;
	}
	

	public int getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	} 


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
