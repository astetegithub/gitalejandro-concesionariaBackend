package com.concesionaria.practica.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.practica.entity.Color;
import com.concesionaria.practica.entity.Vehiculo;
import com.concesionaria.practica.models.services.IVehiculoService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/inicio")
public class VehiculoRestController {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> inicio(){
		return vehiculoService.findAll(); 
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/descuentos")
	public List<Vehiculo> descuentos(){
		return vehiculoService.descuentos();
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/vehiculo/{id}")
	public ResponseEntity<?> getVehiculo(@PathVariable int id) {
		
		Vehiculo vehiculo = null;
		Map<String, Object> respuesta = new HashMap<>();
		
		try { 
			vehiculo = vehiculoService.findById(id); 
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error en la consulta a la abse de datos");
			respuesta.put("error", "Error en la consulta a la abse de datos" + e.getMessage());
			
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		if (vehiculo == null) {
			respuesta.put("mensaje", "El vehiculo con id " + id + " no existe");
			 
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
	}
	
	
	@GetMapping("/buscador/{tipo}/{condicion}/{precioMinimo}/{precioMaximo}/{kmMinimo}/{kmMaximo}") 
	public ResponseEntity<?> buscador(@PathVariable String tipo, @PathVariable String condicion,
			@PathVariable Double precioMinimo, @PathVariable Double precioMaximo, 
			@PathVariable Double kmMinimo, @PathVariable Double kmMaximo){
		
		
		
		List<Vehiculo> vehiculos = null;
		Map<String, Object> respuesta = new HashMap<>();
		
		try { 
			vehiculos = vehiculoService.buscador(tipo, condicion, precioMinimo, precioMaximo, kmMinimo, kmMaximo); 
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error en la consulta a la base de datos");
			respuesta.put("error", "Error en la consulta a la abse de datos" + e.getMessage());
			
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (vehiculos.size() == 0) {
			respuesta.put("mensaje", "No encontramos vehiculos para estos criterios.");
			 
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
			
		
		return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK); 
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/descuentos/{descuento}")
	public List<Vehiculo> descuento(@PathVariable Double descuento){
		
		return vehiculoService.descuento(descuento);	
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/favoritos/{id}")
	public List<Vehiculo> favoritos(@PathVariable int id){ 
		
		return vehiculoService.favoritos(id); 
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/favoritos/{idVehiculo}/{idCliente}")
	public void agregarFavorito(@PathVariable int idVehiculo, @PathVariable int idCliente) {
		vehiculoService.agregarFavorito(idVehiculo, idCliente);
	}
	
	@Secured("ROLE_USER")
	@DeleteMapping("/favoritos/{idVehiculo}/{idCliente}")
	public void eliminarFavorito(@PathVariable int idVehiculo, @PathVariable int idCliente) {
		vehiculoService.eliminarFavorito(idVehiculo, idCliente);
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/solicitud/{idVehiculo}/{idCliente}")
	public void solicitud(@PathVariable int idVehiculo, @PathVariable int idCliente) {
		vehiculoService.solicitud(idVehiculo, idCliente); 
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/colores/{idVehiculo}")
	public List<Color> coloresVehiculo(@PathVariable int idVehiculo){
		return vehiculoService.coloresVehiculo(idVehiculo);
	}
	 

}
 