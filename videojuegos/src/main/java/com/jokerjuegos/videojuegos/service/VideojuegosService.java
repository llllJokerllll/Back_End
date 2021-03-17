package com.jokerjuegos.videojuegos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jokerjuegos.videojuegos.domain.Videojuego;
import com.jokerjuegos.videojuegos.repository.VideojuegosRepository;

@Service
public class VideojuegosService {
	
	private final VideojuegosRepository videojuegoRepository;
	
	public VideojuegosService(VideojuegosRepository videojuegoRepository) {
		this.videojuegoRepository = videojuegoRepository;
	}

	public List<Videojuego> buscarDestacados() {
		
		return videojuegoRepository.buscarTodos();
	}
	
	public List<Videojuego> buscarPorDistribuidor(int distribuidorId) {
		
		return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
	}
	
	public List<Videojuego> buscar(String consulta) {
		return videojuegoRepository.findByNombreContaining(consulta);
	}
	
	public Videojuego guardar(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}
}
