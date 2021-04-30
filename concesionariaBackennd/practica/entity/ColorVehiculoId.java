package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColorVehiculoId implements Serializable{
	
	@Column(name = "id_color")
	private int idColor;
	
	@Column(name = "id_vehiculo")
	private int idVehiculo;
	
	

	public ColorVehiculoId() {}
	

	public ColorVehiculoId(int idColor, int idVehiculo) {
		this.idColor = idColor;
		this.idVehiculo = idVehiculo;
	}

	


	public int getIdColor() {
		return idColor;
	}


	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}


	public int getIdVehiculo() {
		return idVehiculo;
	}


	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idColor;
		result = prime * result + idVehiculo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorVehiculoId other = (ColorVehiculoId) obj;
		if (idColor != other.idColor)
			return false;
		if (idVehiculo != other.idVehiculo)
			return false;
		return true;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
