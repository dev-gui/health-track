package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dieta")
public class DietaController {

	@GetMapping
	public String dieta() {
		return "/paginas/dieta";
	}
}
