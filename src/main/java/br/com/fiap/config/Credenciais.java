package br.com.fiap.config;

import java.io.Serializable;

public class Credenciais implements Serializable{
	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;
	
	public Credenciais() {
		
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
