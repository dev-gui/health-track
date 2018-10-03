package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pressao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private Integer pressaoBaixa;
	
	private Integer pressaoAlta;
	
	private Date data;
	
	// Atributo referencial
	private Usuario usuarioId;
	
	public Pressao() {}

	public Pressao(Integer id, Integer pressaoBaixa, Integer pressaoAlta, Date data, Usuario usuarioId) {
		this.id = id;
		this.pressaoBaixa = pressaoBaixa;
		this.pressaoAlta = pressaoAlta;
		this.data = data;
		this.usuarioId = usuarioId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPressaoBaixa() {
		return pressaoBaixa;
	}

	public Integer getPressaoAlta() {
		return pressaoAlta;
	}

	public Date getData() {
		return data;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPressaoBaixa(Integer pressaoBaixa) {
		this.pressaoBaixa = pressaoBaixa;
	}

	public void setPressaoAlta(Integer pressaoAlta) {
		this.pressaoAlta = pressaoAlta;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
}
