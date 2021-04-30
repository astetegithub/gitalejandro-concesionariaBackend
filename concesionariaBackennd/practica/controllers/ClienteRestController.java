package com.concesionaria.practica.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.practica.entity.Cliente;
import com.concesionaria.practica.entity.DireccionEdificio;
import com.concesionaria.practica.entity.DireccionIndividual;
import com.concesionaria.practica.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/registro")
	public ResponseEntity<?> registro(@Valid  @RequestBody Cliente cliente, BindingResult resultado) {
		
		
		Cliente clienteNuevo = null;
		
		Map<String, Object> respuesta = new HashMap<>();
		
		if (resultado.hasErrors()) {
	
			List<String> errores = resultado.getFieldErrors()
					.stream()
					.map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList());
			
			respuesta.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			String passwordBcrypt = passwordEncoder.encode(cliente.getPassword());
			
			cliente.setPassword(passwordBcrypt);
			
			clienteNuevo = clienteService.save(cliente);
		
			clienteService.agregarRol(cliente.getIdCliente(), 1);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear el nuevo cliente");
			respuesta.put("error", "Error en la consulta a la abse de datos" + e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "El cliente ha sido creado con exito");
		
		respuesta.put("cliente", clienteNuevo);
		
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/cuenta/{id}")
	public Cliente getCliente(@PathVariable int id) {
		Cliente cliente = null;
		cliente = clienteService.findById(id);
		return cliente;
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/direccion/edificio")
	public DireccionEdificio saveDireccionEdificio(@RequestBody DireccionEdificio direccionEdificio) {
		
		return clienteService.save(direccionEdificio);
	}
	
	@Secured("ROLE_USER")
	@PostMapping("direccion/individual")
	public DireccionIndividual saveDireccionIndividual(@RequestBody DireccionIndividual direccionIndividual) {
		return clienteService.save(direccionIndividual);
	}
   
}
