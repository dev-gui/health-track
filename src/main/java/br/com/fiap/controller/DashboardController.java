package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.repository.AlimentacaoRepository;
import br.com.fiap.repository.AtividadeRepository;
import br.com.fiap.repository.PesoRepository;
import br.com.fiap.repository.PressaoRepository;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private AlimentacaoRepository aliDao;
	
	@Autowired
	private PressaoRepository preDao;
	
	@Autowired
	private PesoRepository pesDao;
	
	@Autowired
	private AtividadeRepository atiDao;
	
	@GetMapping
	public String conteudo(ModelMap model) {
		model.addAttribute("alimentacoes", aliDao.findAll());
		model.addAttribute("pressoes", preDao.findAll());
		model.addAttribute("pesos", pesDao.findAll());
		model.addAttribute("atividades", atiDao.findAll());
		return "/fragments/resumo";
	}
	
	
}
