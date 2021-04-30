package com.concesionaria.practica.models.services;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concesionaria.practica.entity.Cliente;
import com.concesionaria.practica.entity.DireccionEdificio;
import com.concesionaria.practica.entity.DireccionIndividual;
import com.concesionaria.practica.models.dao.IClienteDao;
import com.concesionaria.practica.models.dao.IDireccionEdificioDao;
import com.concesionaria.practica.models.dao.IDireccionIndividualDao;

@Service
public class ClienteServiceImpl implements IClienteService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IDireccionEdificioDao direccionEdificioDao;
	
	@Autowired
	private IDireccionIndividualDao direccionIndividualDao;

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
	
		 return clienteDao.save(cliente); 
	}

	@Override
	@Transactional(readOnly = true )
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Cliente cliente = clienteDao.findByUsuario(username);
		
		if (cliente == null) {
			logger.error("No existe el cliente");
			throw new UsernameNotFoundException("No existe el cliente trow");
		}
		
	    List<GrantedAuthority> authorities = cliente.getRoles()
	    		.stream()
	    		.map(role -> new SimpleGrantedAuthority(role.getNombre()))
	    		.collect(Collectors.toList());
	    
	    
		
		return new User(cliente.getUsuario(), cliente.getPassword(), true, true, true, true, authorities);
	}

	@Override 
	public Cliente findByUsuario(String usuario) {
		
		return clienteDao.findByUsuario(usuario); 
	}

	@Override
	public Cliente findById(int id) {
		
		return clienteDao.findById(id);
	}

	@Override
	public void agregarRol(int cliente, int rol) {
		clienteDao.agregarRol(cliente, rol);
	}

	@Override
	public DireccionEdificio save(DireccionEdificio direccionEdificio) {
		
		return direccionEdificioDao.save(direccionEdificio);
	}

	@Override
	public DireccionIndividual save(DireccionIndividual direccionIndividual) {
		return direccionIndividualDao.save(direccionIndividual);
	}	
	
	

}
