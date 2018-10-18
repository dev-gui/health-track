package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.domain.Usuario;
import br.com.fiap.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastrar")
public class CadastroController {
	
	@Autowired
	private UsuarioRepository dao;

	@GetMapping
	public String cadastro(Usuario usuario) {
		return "/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario) {
		dao.save(usuario);
		return "redirect:/fragments/resumo";
	} 
}
