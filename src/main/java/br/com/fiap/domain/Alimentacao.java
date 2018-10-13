package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alimentacao implements Calorias, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private Date data;
	
	private float alimentacao1;
	
	private float alimentacao2;
	
	private float alimentacao3;
	
	private float alimentacao4;
	
	private float alimentacao5;
	
	private float alimentacao6;
	
	// Atributo relacional
	@ManyToOne
	private Usuario usuarioId;
	
	public Alimentacao() {}

	public Alimentacao(Integer id, Date data, float alimentacao1, float alimentacao2, float alimentacao3,
			float alimentacao4, float alimentacao5, float alimentacao6, Usuario usuarioId) {
		this.id = id;
		this.data = data;
		this.alimentacao1 = alimentacao1;
		this.alimentacao2 = alimentacao2;
		this.alimentacao3 = alimentacao3;
		this.alimentacao4 = alimentacao4;
		this.alimentacao5 = alimentacao5;
		this.alimentacao6 = alimentacao6;
		this.usuarioId = usuarioId;
	}

	public Integer getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public float getAlimentacao1() {
		return alimentacao1;
	}

	public float getAlimentacao2() {
		return alimentacao2;
	}

	public float getAlimentacao3() {
		return alimentacao3;
	}

	public float getAlimentacao4() {
		return alimentacao4;
	}

	public float getAlimentacao5() {
		return alimentacao5;
	}

	public float getAlimentacao6() {
		return alimentacao6;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setAlimentacao1(float alimentacao1) {
		this.alimentacao1 = alimentacao1;
	}

	public void setAlimentacao2(float alimentacao2) {
		this.alimentacao2 = alimentacao2;
	}

	public void setAlimentacao3(float alimentacao3) {
		this.alimentacao3 = alimentacao3;
	}

	public void setAlimentacao4(float alimentacao4) {
		this.alimentacao4 = alimentacao4;
	}

	public void setAlimentacao5(float alimentacao5) {
		this.alimentacao5 = alimentacao5;
	}

	public void setAlimentacao6(float alimentacao6) {
		this.alimentacao6 = alimentacao6;
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
		Alimentacao other = (Alimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public float calcularCalorias() {
		return alimentacao1 + alimentacao2 + alimentacao3 + alimentacao4 + alimentacao5 + alimentacao6;
	}
	
	
}
