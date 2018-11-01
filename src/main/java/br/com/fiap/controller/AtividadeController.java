package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Atividade;
import br.com.fiap.domain.Esporte;
import br.com.fiap.repository.AtividadeRepository;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeRepository dao;
	
	@GetMapping
	public String atividades(Atividade atividade, ModelMap model) {
		model.addAttribute("atividades", dao.findAll());
		return "/fragments/atividade";
	}
	
	@GetMapping("/add-atividade")
	public String addAtividades(Atividade atividade) {
		return "/fragments/add-atividade";
	}
	
	@PostMapping("/salvar")
	public String cadastrar(@ModelAttribute("form1") Atividade atividade) {
		dao.save(atividade);
		return "redirect:/atividade";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar (@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("atividade", dao.getOne(id));
		return "/fragments/add-atividade";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute("form1") Atividade atividade) {
		dao.save(atividade);
		return "redirect:/dashboard";
	}
	
	@ModelAttribute("esporte")
	public Esporte[] getEsportes() {
		return Esporte.values();
	}
}
