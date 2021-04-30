package com.concesionaria.practica.models.services;


import java.util.List;

import com.concesionaria.practica.entity.Color;
import com.concesionaria.practica.entity.Vehiculo;

public interface IVehiculoService {
	
	public List<Vehiculo> findAll();
	
	public Vehiculo findById(int id);
	
	public List<Vehiculo> buscador(String tipo, String condicion, Double precioMinimo,
			Double precioMaximo, Double kmMinimo, Double kmMaximo);
	
	public List<Vehiculo> descuentos();
	
	public List<Vehiculo> descuento(Double descuento);
	
	public List<Vehiculo> favoritos(int id);
	
	public void agregarFavorito(int idVehiculo, int idCliente);
	
	public void eliminarFavorito(int idVehiculo, int idCliente);
	
	public void solicitud(int idVehiculo, int idCliente);
	
	public List<Color> coloresVehiculo(int idVehiculo);

}
 