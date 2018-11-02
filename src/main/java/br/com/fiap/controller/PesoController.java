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

import br.com.fiap.domain.Peso;
import br.com.fiap.repository.PesoRepository;

@Controller
@RequestMapping("/peso")
public class PesoController {
	
	@Autowired
	private PesoRepository dao;
	
	@GetMapping("/add-peso")
	public String addPeso(Peso peso) {
		return "/fragments/add-peso";
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("form1") Peso peso, RedirectAttributes att) {
		dao.save(peso);
		att.addFlashAttribute("sucesso", "Peso salvo com sucesso.");
		return "redirect:/peso/add-peso";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		model.addAttribute("pesos", dao.findAll());
		return "/fragments/peso";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("peso", dao.getOne(id));
		return "fragments/add-peso";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute("form1") Peso peso, RedirectAttributes att) {
		dao.save(peso);
		att.addFlashAttribute("sucesso", "Peso editado com sucesso.");
		return "redirect:/peso/add-peso";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes att) {
		dao.deleteById(id);
		att.addFlashAttribute("sucesso", "Peso excluído com sucesso.");
		return "redirect:/dashboard";
	}
}
