package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Pressao;

@Controller
@RequestMapping("/pressao")
public class PressaoController {

	@GetMapping
	public String pressao() {
		return "/fragments/pressao";
	}
	
	@GetMapping("/add-pressao")
	public String addPressao(Pressao pressao) {
		return "/fragments/add-pressao";
	}
}
