package com.concesionaria.practica.models.services;

import com.concesionaria.practica.entity.Cliente;
import com.concesionaria.practica.entity.DireccionEdificio;
import com.concesionaria.practica.entity.DireccionIndividual;

public interface IClienteService {
	
	public Cliente save(Cliente cliente);
	
	public Cliente findByUsuario(String usuario);
	
	public Cliente findById(int id);
	
	
	public void agregarRol(int cliente, int rol);
	
	public DireccionEdificio save(DireccionEdificio direccionEdificio);
	
	public DireccionIndividual save(DireccionIndividual direccionIndividual);

}
