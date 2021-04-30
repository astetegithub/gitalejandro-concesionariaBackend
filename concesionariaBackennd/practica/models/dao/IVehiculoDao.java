package com.concesionaria.practica.models.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.concesionaria.practica.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Integer>{
	
	
	@Query(value="select * from vehiculos where tipo_v = :tipo and condicion = :condicion"
			+ " and precio between :precioMinimo and :precioMaximo and kilometraje between :kmMinimo and :kmMaximo", nativeQuery = true)
	public List<Vehiculo> buscador(@Param("tipo") String tipo, @Param("condicion") String condicion, 
			 @Param("precioMinimo") Double precioMinimo,  @Param("precioMaximo") Double precioMaximo,
			 @Param("kmMinimo") Double kmMinimo, @Param("kmMaximo") Double kmMaximo);
	
	@Query(value = "select * from vehiculos as v\r\n" + 
			"where v.descuento is not null", nativeQuery = true)
	public List<Vehiculo> descuentos();
	
	@Query(value = "select * from vehiculos as v where v.descuento = :descuento", nativeQuery = true)
	public List<Vehiculo> descuento(@Param("descuento") Double descuentos); 
	
	@Query(value = "select * from favorito as f inner join vehiculos as v on f.id_vehiculo = v.id_vehiculo where f.id_cliente = :id", nativeQuery = true)
	public List<Vehiculo> favoritos(@Param("id") int id);  
	
	@Modifying
	@Transactional
	@Query(value = "insert into favorito (id_vehiculo, id_cliente) values (:idVehiculo, :idCliente)", nativeQuery = true)
	public void agregarFavorito(@Param("idVehiculo") int idVehiculo, @Param("idCliente") int idCliente);
	
	@Modifying
	@Transactional
	@Query(value = "delete from favorito as f where f.id_vehiculo = :idVehiculo and f.id_cliente = :idCliente", nativeQuery = true)
	public void eliminarFavorito(@Param("idVehiculo") int idVehiculo, @Param("idCliente") int idCliente);
	
	@Modifying
	@Transactional
	@Query(value = "insert into solicitudes (id_vehiculo, id_cliente) values (:idVehiculo, :idCliente)", nativeQuery = true) 
	public void solicitud(@Param("idVehiculo") int idVehiculo, @Param("idCliente") int idCliente);
	
	
  
}
