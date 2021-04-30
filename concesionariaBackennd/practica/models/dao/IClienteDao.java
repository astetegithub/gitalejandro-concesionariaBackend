package com.concesionaria.practica.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.concesionaria.practica.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{
	
	public Cliente findByUsuario(String usuario);
	
	public Cliente findById(int id);
	
	@Modifying
	@Transactional
	@Query(value = "insert into cliente_roles (cliente_id, rol_id) values (:cliente, :rol)", nativeQuery = true)
	public void agregarRol(@Param("cliente") int cliente, @Param("rol") int rol);
	
}
 