package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "colorvehiculo")
public class ColorVehiculo implements Serializable {

	@EmbeddedId
	private ColorVehiculoId id;
	
	@ManyToOne
	@MapsId("id_color")
	@JoinColumn(name = "id_color")
	private Color color;
	
	@ManyToOne
	@MapsId("id_vehiculo")
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	
	@Column(name = "uni_disponibles")
	private int uniDisponibles;

	public ColorVehiculo() {}

	public ColorVehiculo(ColorVehiculoId id, Color color, Vehiculo vehiculo, int uniDisponibles) {
		
		this.id = id;
		this.color = color;
		this.vehiculo = vehiculo;
		this.uniDisponibles = uniDisponibles;
	}

	public ColorVehiculoId getId() {
		return id;
	}

	public void setId(ColorVehiculoId id) {
		this.id = id;
	}

	public Color getColor() {
		return color; 
	}
 
	public void setColor(Color color) {
		this.color = color;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getUniDisponibles() {
		return uniDisponibles;
	}

	public void setUniDisponibles(int uniDisponibles) {
		this.uniDisponibles = uniDisponibles;
	}
	
	private static final long serialVersionUID = 1L;

}
