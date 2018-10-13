package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private Integer status;
	
	@ManyToOne
	private Usuario usuarioId;
	
	public Pressao() {}

	public Pressao(Integer id, Integer pressaoBaixa, Integer pressaoAlta, Date data, Usuario usuarioId, PressaoStatus status) {
		this.id = id;
		this.pressaoBaixa = pressaoBaixa;
		this.pressaoAlta = pressaoAlta;
		this.data = data;
		this.usuarioId = usuarioId;
		this.status = status.getCod();
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
	
	public PressaoStatus getStatus() {
		return PressaoStatus.toEnum(status);
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
	
	public void setStatus(PressaoStatus status) {
		this.status = status.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pressao other = (Pressao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
