package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pressao")
public class PressaoController {

	@GetMapping
	public String pressao() {
		return "/paginas/pressao";
	}
}
