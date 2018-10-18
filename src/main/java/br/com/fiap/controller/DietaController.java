package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Alimentacao;

@Controller
@RequestMapping("/alimentacao")
public class DietaController {

	@GetMapping
	public String alimentacao() {
		return "/fragments/alimentacao";
	}
	
	@GetMapping("/add-alimentacao")
	public String addAlimentacao(Alimentacao alimentacao) {
		return "/fragments/add-alimentacao";
	}
}
