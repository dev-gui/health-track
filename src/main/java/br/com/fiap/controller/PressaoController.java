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

import br.com.fiap.domain.Pressao;
import br.com.fiap.repository.PressaoRepository;

@Controller
@RequestMapping("/pressao")
public class PressaoController {
	
	@Autowired
	private PressaoRepository dao;

	@GetMapping
	public String pressao(ModelMap model) {
		model.addAttribute("pressoes", dao.findAll());
		return "/fragments/pressao";
	}
	
	@GetMapping("/add-pressao")
	public String addPressao(Pressao pressao) {
		return "/fragments/add-pressao";
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("form1") Pressao pressao, RedirectAttributes att) {
		dao.save(pressao);
		att.addFlashAttribute("sucesso", "Pressão salva com sucesso.");
		return "redirect:/pressao/add-pressao";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("pressao", dao.getOne(id));
		return "/fragments/add-pressao";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute("form1") Pressao pressao, RedirectAttributes att) {
		dao.save(pressao);
		att.addFlashAttribute("sucesso", "Pressão excluída com sucesso.");
		return "redirect:/pressao/add-pressao";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes att) {
		dao.deleteById(id);
		att.addFlashAttribute("sucesso", "Pressão excluída com sucesso.");
		return "redirect:/dashboard";
	}
}
