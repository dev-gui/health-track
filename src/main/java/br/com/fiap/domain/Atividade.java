package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade implements Calorias, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTermino;
	
	private Float distancia;

	private Float calorias;
	
	private Esporte esporte;
	
	private Usuario usuarioId;
	
	public Atividade() {}

	public Atividade(Integer id, Date dataInicio, Date dataTermino, Float distancia, Float calorias, Esporte esporte,
			Usuario usuarioId) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.distancia = distancia;
		this.calorias = calorias;
		this.esporte = esporte;
		this.usuarioId = usuarioId;
	}

	public Integer getId() {
		return id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public Float getDistancia() {
		return distancia;
	}

	public Float getCalorias() {
		return calorias;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public float calcularCalorias() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

