package com.concesionaria.practica.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="individual")
public class DireccionIndividual extends Direccion{
	
	private String tipoVivienda;

	public DireccionIndividual() {}
	

	public DireccionIndividual(int idDireccion, String provincia, String ciudad, String calle, int altura,
			String entreCalleA, String entreCalleB, String tipoVivienda) {
		super(idDireccion, provincia, ciudad, calle, altura, entreCalleA, entreCalleB);
		this.tipoVivienda = tipoVivienda;
	}
	

	public String getTipoVivienda() {
		return tipoVivienda;
	}




	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
