package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Alimentacao;
import br.com.fiap.repository.AlimentacaoRepository;

@Controller
@RequestMapping("/alimentacao")
public class DietaController {
	
	@Autowired
	private AlimentacaoRepository dao;

	@GetMapping
	public String alimentacao(ModelMap model) {
		model.addAttribute("alimentacoes", dao.findAll());
		return "/fragments/alimentacao";
	}
	
	@GetMapping("/add-alimentacao")
	public String addAlimentacao(Alimentacao a) {
		return "/fragments/add-alimentacao";
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("form1") Alimentacao alimentacao) {
		dao.save(alimentacao);
		return "redirect:/alimentacao";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("alimentacao", dao.getOne(id));
		return "/fragments/add-alimentacao";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute("form1") Alimentacao alimentacao) {
		dao.save(alimentacao);
		return "redirect:/dashboard";
	}
}
