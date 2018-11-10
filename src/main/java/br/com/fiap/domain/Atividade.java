package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Atividade implements Calorias, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	private Date duracao;
	
	@NumberFormat(style=Style.NUMBER)
	private Float distancia;
	
	
	private Integer esporte;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarioId;
	
	public Atividade() {}

	public Atividade(Integer id, Date data, Date duracao, Float distancia, Esporte esporte,
			Usuario usuarioId) {
		this.id = id;
		this.data = data;
		this.duracao = duracao;
		this.distancia = distancia;
		this.esporte = esporte.getCod();
		this.usuarioId = usuarioId;
	}

	public Integer getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Date getDuracao() {
		return duracao;
	}

	public Float getDistancia() {
		return distancia;
	}

	public Esporte getEsporte() {
		return Esporte.toEnum(esporte);
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte.getCod();
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
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
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public double calcularCalorias() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	
	
	
}

