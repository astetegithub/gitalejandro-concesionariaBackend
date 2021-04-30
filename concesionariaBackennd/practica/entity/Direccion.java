package com.concesionaria.practica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name="tipo_d", discriminatorType=DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Direccion implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDireccion;
	
	private String provincia;
	
	private String ciudad;
	
	private String calle;
	
	private int altura;
	
	@Column(name = "entre_calle_a")
	private String entreCalleA;
	  
	@Column(name = "entre_calle_b")
	private String entreCalleB;
	
	@ManyToOne
	@JoinColumn(name = "cliente") 
	private Cliente cliente;
	
	public Direccion() {}  

	public Direccion(int idDireccion, String provincia, String ciudad, String calle, int altura, String entreCalleA,
			String entreCalleB) {
	
		this.idDireccion = idDireccion;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.entreCalleA = entreCalleA; 
		this.entreCalleB = entreCalleB;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getEntreCalleA() {
		return entreCalleA;
	}

	public void setEntreCalleA(String entreCalleA) {
		this.entreCalleA = entreCalleA;
	}

	public String getEntreCalleB() {
		return entreCalleB;
	}

	public void setEntreCalleB(String entreCalleB) {
		this.entreCalleB = entreCalleB;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 

 
}
