package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Atividade;
import br.com.fiap.repository.AtividadeRepository;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeRepository dao;
	
	@GetMapping
	public String atividades(Atividade atividade) {
		return "/fragments/atividade";
	}
	
	@GetMapping("/add-atividade")
	public String addAtividades(Atividade atividade) {
		return "/fragments/add-atividade";
	}
	
	@PostMapping("/salvar")
	public String cadastrar(Atividade atividade) {
		dao.save(atividade);
		return "redirect:/fragments/atividade";
	}
}
