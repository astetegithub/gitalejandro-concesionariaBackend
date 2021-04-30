package com.concesionaria.practica.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_v", discriminatorType=DiscriminatorType.STRING)
@Table(name="vehiculos")
public abstract class Vehiculo  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_vehiculo;
	
	private Double precio;
	
	private String condicion;
	
	private int anioCreacion;
	
	private Double kilometraje;
	
	private int stock;
	
	private String descripcion; 
	
	@OneToMany(mappedBy = "vehiculo",
			cascade = CascadeType.ALL,
			orphanRemoval = true)  
	private  List<Imagen> imagenes;   

	@ManyToMany(mappedBy="vehiculosFav") 																																																																																																																																																																																																																																																																																																																																																																																															
	private List<Cliente> clientesFav;
	
	@ManyToMany(mappedBy="solicitudes") 
	private List<Cliente> solicitudesClientes;   
                                                                    
	@ManyToOne(fetch = FetchType.EAGER)           
	@JoinColumn(name = "marca")
	private Marca marca;        
	  
	 
	@OneToMany(mappedBy = "vehiculo",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<ColorVehiculo> coloresVehiculos; 
	
	private Double descuento;
	
	@Column(insertable = false, updatable = false, name = "tipo_v")
	private String tipoVehiculo;
	 
	private Double precioDescuento;
	
	 
	   
	public Vehiculo() {}
	
	public Vehiculo(int id_vehiculo, Double precio, String condicion, int anioCreacion, Double kilometraje, int stock,
			String descripcion, Marca marca, Double precioDescuento) { 
		this.id_vehiculo = id_vehiculo;
		this.precio = precio; 
		this.condicion = condicion; 
		this.anioCreacion = anioCreacion;
		this.kilometraje = kilometraje;
		this.stock = stock;
		this.descripcion = descripcion; 
		this.marca = marca;
		this.precioDescuento = precioDescuento;
	}
 	
	@JsonManagedReference
	public Double getDescuento() {
		return descuento;
	} 
	 
	@JsonBackReference
	public List<ColorVehiculo> getColoresVehiculos() {
		return coloresVehiculos;
	}

	public void setColoresVehiculos(List<ColorVehiculo> coloresVehiculos) {
		this.coloresVehiculos = coloresVehiculos;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	
	public int getIdVehiculo() {
		return id_vehiculo; 
	}


	@JsonBackReference
	public List<Imagen> getImagenes() {  
		return imagenes;
	}
  
	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.id_vehiculo = idVehiculo; 
	}
 

  
	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public String getCondicion() {
		return condicion;
	}



	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}



	public int getAnioCreacion() {
		return anioCreacion;
	}



	public void setAnioCreacion(int anioCreacion) {
		this.anioCreacion = anioCreacion;
	}



	public Double getKilometraje() {
		return kilometraje;
	}



	public void setKilometraje(Double kilometraje) {
		this.kilometraje = kilometraje;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}


 
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

 
	public Marca getMarca() {
		return marca;
	}

  

	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipo_v(String tipoV) {
		this.tipoVehiculo = tipoV;
	}
	
	public Double getPrecioDescuento() {
		return precioDescuento;
	}

	public void setPrecioDescuento(Double precioDescuento) {
		this.precioDescuento = precioDescuento;
	}
	@JsonBackReference("solicitudes")
	public List<Cliente> getSolicitudesClientes() {
		return solicitudesClientes;
	}

	public void setSolicitudesClientes(List<Cliente> solicitudesClientes) {
		this.solicitudesClientes = solicitudesClientes;
	}





	private static final long serialVersionUID = 1L; 
	  
}
