package com.jokerjuegos.videojuegos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jokerjuegos.videojuegos.domain.Videojuego;
import com.jokerjuegos.videojuegos.service.VideojuegosService;

@Controller
public class ListadoController {

	private final VideojuegosService videojuegoService;
	
	public ListadoController(VideojuegosService videojuegoService) {
		this.videojuegoService = videojuegoService;
	}
	
	@RequestMapping("/")
	public String listarVideojuegos(Model model) {
		// Busqueda de los videojuegos
		List<Videojuego> destacados = videojuegoService.buscarDestacados();
		model.addAttribute("videojuegos", destacados);
		return "listado";
	}
	
	@RequestMapping("/videojuegosPorDistribuidor")
	public String listarVideojuegosPorDistribuidor(int distribuidorId, Model model) {
		List<Videojuego> distribuidores = videojuegoService.buscarPorDistribuidor(distribuidorId);
		model.addAttribute("videojuegos", distribuidores);
		return "listado";
	}
	
	@RequestMapping("/buscar")
	public String buscar(@RequestParam("q") String consulta, Model model) {
		List<Videojuego> juegos = videojuegoService.buscar(consulta);
		model.addAttribute("videojuegos", juegos);
		return "listado";
	}
}
