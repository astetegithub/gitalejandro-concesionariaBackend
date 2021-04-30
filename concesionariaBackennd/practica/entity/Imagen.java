package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="imagen")
public class Imagen implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idImg;
	
	private String nombreImg;
	
	private String ubicacionImg;
	
	@ManyToOne
	@JoinColumn(name = "vehiculo")
	private Vehiculo vehiculo;   
	  
	public Imagen() {}  
	
	public Imagen(int idImagen, String nombreImg, String ubicacion, Vehiculo vehiculo) {
		this.idImg = idImagen;
		this.nombreImg = nombreImg;
		this.ubicacionImg = ubicacion;
	}


	public int getIdImagen() { 
		return idImg;
	}  
	public void setIdImagen(int idImagen) {
		this.idImg = idImagen; 
	}   
	public String getNombreImg() {   
		return nombreImg;
	}
	public void setNombreImg(String nombreImg) { 
		this.nombreImg = nombreImg;
	}
	public String getUbicacion() {
		return ubicacionImg;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacionImg = ubicacion;
	}
	
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	private static final long serialVersionUID = 1L;

}
