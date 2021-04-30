package com.concesionaria.practica.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionaria.practica.entity.Color;
import com.concesionaria.practica.entity.Vehiculo;
import com.concesionaria.practica.models.dao.IColorDao;
import com.concesionaria.practica.models.dao.IVehiculoDao;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoDao vehiculoDao;
	
	@Autowired
	private IColorDao colorDao;


	@Override
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	public Vehiculo findById(int id) {
		return vehiculoDao.findById(id).orElse(null);
	}


	@Override
	public List<Vehiculo> buscador(String tipo, String condicion, Double precioMinimo, Double precioMaximo,
			Double kmMinimo, Double kmMaximo) {
		
		return vehiculoDao.buscador(tipo, condicion, precioMinimo, precioMaximo, kmMinimo, kmMaximo);
	}

	@Override
	public List<Vehiculo> descuentos() {
		return vehiculoDao.descuentos();
	}

	@Override
	public List<Vehiculo> descuento(Double descuento) {
		return vehiculoDao.descuento(descuento); 
	}

	@Override
	public List<Vehiculo> favoritos(int id) {
		return vehiculoDao.favoritos(id);
	}

	@Override
	public void agregarFavorito(int idVehiculo, int idCliente) {
		vehiculoDao.agregarFavorito(idVehiculo, idCliente);	
	}

	@Override
	public void eliminarFavorito(int idVehiculo, int idCliente) {
		vehiculoDao.eliminarFavorito(idVehiculo, idCliente);	
	}

	@Override
	public void solicitud(int idVehiculo, int idCliente) {
		vehiculoDao.solicitud(idVehiculo, idCliente);
	}
	
	@Override
	public List<Color> coloresVehiculo(int idVehiculo) {
		return colorDao.coloresVehiculo(idVehiculo);
	}
		

} 
  