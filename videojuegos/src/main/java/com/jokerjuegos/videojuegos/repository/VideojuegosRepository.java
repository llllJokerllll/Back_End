package com.jokerjuegos.videojuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jokerjuegos.videojuegos.domain.Videojuego;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer>{

	@Query(value="select * from Videojuego order by nombre", nativeQuery = true)
	List<Videojuego> buscarTodos();
	
	@Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
	List<Videojuego> buscarPorDistribuidor(int distribuidorId);
	
	//@Query("from Videojuego v where v.nombre like %?1%")
	List<Videojuego> findByNombreContaining(String consulta);
}
