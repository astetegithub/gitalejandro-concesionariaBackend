package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="camion")
public class Camion extends Vehiculo implements Serializable{
	
	@Column(nullable = true)
	private int numeroAcoplados;
	@Column(nullable = true)
	private Double cargaMaxima;
	
	public Camion() {}

	public Camion(int idVehiculo, Double precio, String condicion, int anioCreacion, Double kilometraje, int stock,
			String descripcion, Marca marca, Double precioDescuento, int numeroAcoplados, Double cargaMaxima) {
		super(idVehiculo, precio, condicion, anioCreacion, kilometraje, stock, descripcion, marca, precioDescuento);
		this.numeroAcoplados = numeroAcoplados;
		this.cargaMaxima = cargaMaxima;
	}

	public int getNumeroCoplados() {
		return numeroAcoplados; 
	}

	public void setNumeroCoplados(int numeroAcoplados) {
		this.numeroAcoplados = numeroAcoplados;
	}

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}
	 
	private static final long serialVersionUID = 1L;


}
