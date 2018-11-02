package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String cadastrar(@ModelAttribute("form1") Atividade atividade, RedirectAttributes att) {
		dao.save(atividade);
		att.addFlashAttribute("sucesso", "Atividade inserida com sucesso.");
		return "redirect:/atividade/add-atividade";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar (@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("atividade", dao.getOne(id));
		return "/fragments/add-atividade";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute("form1") Atividade atividade, RedirectAttributes att) {
		dao.save(atividade);
		att.addFlashAttribute("sucesso", "Atividade editada com sucesso.");
		return "redirect:/atividade/add-atividade";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes att) {
		dao.deleteById(id);
		att.addFlashAttribute("sucesso", "Atividade excluída com sucesso.");
		return "redirect:/dashboard";
	}
	
	@ModelAttribute("esporte")
	public Esporte[] getEsportes() {
		return Esporte.values();
	}
}
