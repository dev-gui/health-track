package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Peso;

@Controller
@RequestMapping("/peso")
public class PesoController {

	@GetMapping
	public String peso() {
		return "/fragments/peso";
	}
	
	@GetMapping("/add-peso")
	public String addPeso(Peso peso) {
		return "/fragments/add-peso";
	}
}
