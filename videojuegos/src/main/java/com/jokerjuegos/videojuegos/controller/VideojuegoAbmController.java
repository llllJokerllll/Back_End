package com.jokerjuegos.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jokerjuegos.videojuegos.domain.Videojuego;
import com.jokerjuegos.videojuegos.service.DistribuidorService;
import com.jokerjuegos.videojuegos.service.VideojuegosService;

@Controller
public class VideojuegoAbmController {

	private final DistribuidorService distribuidorService;
	private final VideojuegosService videojuegoService;
	
	public VideojuegoAbmController(DistribuidorService distribuidorService, VideojuegosService videojuegoService) {
		this.distribuidorService = distribuidorService;
		this.videojuegoService = videojuegoService;
	}

	@RequestMapping("/videojuegos/crear")
	public String mostrarFormAlta(Model model) {
		model.addAttribute("distribuidores", distribuidorService.buscarTodo());
		model.addAttribute("videojuego", new Videojuego());
		return "formVideojuego";
	}
	
	@PostMapping("/videojuegos/guardar")
	public String guardar(Videojuego videojuego) {
		videojuegoService.guardar(videojuego);
		return "redirect:/";
	}
}
