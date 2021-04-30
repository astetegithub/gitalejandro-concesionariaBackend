package com.concesionaria.practica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@NotEmpty
	@Size(min = 4)
	@Column(unique = true)
	private String usuario;
	
	@Email
	private String  email;
	
	@NotEmpty
	@Size(min = 8)
	private String password;
	
	@NotEmpty
	@Size(min = 4)
	private String nombre;
	
	@NotEmpty
	@Size(min = 4)
	@Column(name = "apellido_paterno")
	private String apellidoA;
	
	@NotEmpty
	@Size(min = 4)
	@Column(name = "apellido_materno")
	private String apellidoB;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="favorito",
				joinColumns = {@JoinColumn(name="id_cliente")},
				inverseJoinColumns = { @JoinColumn(name="id_vehiculo")}
			)
	private List<Vehiculo> vehiculosFav; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="solicitudes",
				joinColumns = {@JoinColumn(name="id_cliente")},
				inverseJoinColumns = { @JoinColumn(name="id_vehiculo")}
			)
	private List<Vehiculo> solicitudes;
	
	@OneToMany(mappedBy = "cliente",
			cascade = CascadeType.ALL,
			orphanRemoval = true)  
	private List<Direccion> direcciones; 
	
	private String enable;
	 
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="cliente_roles",
	joinColumns = @JoinColumn(name="cliente_id"),
	inverseJoinColumns = @JoinColumn(name="rol_id"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"cliente_id", "rol_id"})})
	private List<Role> roles;
	
	 
	public Cliente() {}    

	public Cliente(int idCliente, String usuario, String email, String password, String nombre, String apellidoA,
			String apellidoB) {
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellidoA = apellidoA;
		this.apellidoB = apellidoB;
	} 
	
	
	public List<Vehiculo> getVehiculosFav() {
		return vehiculosFav;
	}

	public void setVehiculosFav(List<Vehiculo> vehiculosFav) {
		this.vehiculosFav = vehiculosFav; 
	} 
	
	public List<Direccion> getDirecciones() { 
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) { 
		this.direcciones = direcciones;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoA() {
		return apellidoA;
	}
 
	public void setApellidoA(String apellidoA) {
		this.apellidoA = apellidoA;
	}

	public String getApellidoB() {
		return apellidoB;
	}

	public void setApellidoB(String apellidoB) {
		this.apellidoB = apellidoB;
	}
	
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public List<Vehiculo> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Vehiculo> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	


	private static final long serialVersionUID = 1L;

}
