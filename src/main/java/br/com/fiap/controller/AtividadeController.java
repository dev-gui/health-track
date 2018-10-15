package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atividades")
public class AtividadeController {

	@GetMapping
	public String atividades() {
		return "/paginas/atividades";
	}
}
