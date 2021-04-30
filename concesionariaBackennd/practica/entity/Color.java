package com.concesionaria.practica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="color")
public class Color implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idColor;
	
	private String nombreColor;
	
	private String codigoColor;
	
	@OneToMany(mappedBy = "color")
	private List<ColorVehiculo> coloresVehiculos;
	
	
	
	public Color() {}  
	
	public Color(int idColor, String nombreColor, String codigoColor) {

		this.idColor = idColor;
		this.nombreColor = nombreColor;
		this.codigoColor = codigoColor;  
	}   
	
	
	
	public int getIdColor() {
		return idColor;
	}
	
	@JsonBackReference
	public List<ColorVehiculo> getColoresVehiculos() {
		return coloresVehiculos;
	}

	public void setColoresVehiculos(List<ColorVehiculo> coloresVehiculos) {
		this.coloresVehiculos = coloresVehiculos;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}

	public String getCodigoColor() {
		return codigoColor;
	}

	public void setCodigoColor(String codigoColor) {
		this.codigoColor = codigoColor;
	}
	
	private static final long serialVersionUID = 1L;
	
}
