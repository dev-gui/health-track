package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@GetMapping
	public String conta() {
		return "/paginas/conta";
	}
}
