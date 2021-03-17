package com.jokerjuegos.videojuegos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jokerjuegos.videojuegos.domain.Distribuidor;
import com.jokerjuegos.videojuegos.repository.DistribuidorRepository;

@Service
public class DistribuidorService {

	private final DistribuidorRepository distribuidorRepository;

	public DistribuidorService(DistribuidorRepository distribuidorRepository) {
		this.distribuidorRepository = distribuidorRepository;
	}
	
	public List<Distribuidor> buscarTodo() {
		return distribuidorRepository.findAll();
	}
}
