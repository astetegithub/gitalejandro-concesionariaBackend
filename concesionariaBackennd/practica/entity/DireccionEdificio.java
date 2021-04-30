package com.concesionaria.practica.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="edificio")
public class DireccionEdificio extends Direccion{
	
	private int pisoEdificio;
	private int numeroDepartamento;
	
	
	public DireccionEdificio() {}
	
	public DireccionEdificio(int idDireccion, String provincia, String ciudad, String calle, int altura,
			String entreCalleA, String entreCalleB, int pisoEdificio, int numeroDepartamento) {
		super(idDireccion, provincia, ciudad, calle, altura, entreCalleA, entreCalleB);
		this.pisoEdificio = pisoEdificio;
		this.numeroDepartamento = numeroDepartamento;
	}

	public int getPisoEdificio() {
		return pisoEdificio;
	}

	public void setPisoEdificio(int pisoEdificio) {
		this.pisoEdificio = pisoEdificio;
	}

	public int getNumeroDepartamento() {
		return numeroDepartamento;
	}

	public void setNumeroDepartamento(int numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
