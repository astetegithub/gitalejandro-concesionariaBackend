package com.concesionaria.practica.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.concesionaria.practica.entity.Color;

public interface IColorDao extends CrudRepository<Color, Integer>{
	
	@Query(value = "select c.id_color, c.nombre_color, c.codigo_color from colorvehiculo  as cv inner join color as c on cv.id_color = c.id_color where cv.id_vehiculo = :idVehiculo", nativeQuery = true)
	public List<Color> coloresVehiculo(@Param("idVehiculo") int idVehiculo);

}
