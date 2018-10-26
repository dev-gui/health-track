package br.com.fiap.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Alimentacao implements Calorias, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao1;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao2;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao3;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao4;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao5;
	
	@NumberFormat(style=Style.NUMBER)
	private Double alimentacao6;
	
	// Atributo relacional
	@ManyToOne
	private Usuario usuarioId;
	
	public Alimentacao() {}

	public Alimentacao(Long id, Date data, Double alimentacao1, Double alimentacao2, Double alimentacao3,
			Double alimentacao4, Double alimentacao5, Double alimentacao6, Usuario usuarioId) {
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

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Double getAlimentacao1() {
		return alimentacao1;
	}

	public Double getAlimentacao2() {
		return alimentacao2;
	}

	public Double getAlimentacao3() {
		return alimentacao3;
	}

	public Double getAlimentacao4() {
		return alimentacao4;
	}

	public Double getAlimentacao5() {
		return alimentacao5;
	}

	public Double getAlimentacao6() {
		return alimentacao6;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setAlimentacao1(Double alimentacao1) {
		this.alimentacao1 = alimentacao1;
	}

	public void setAlimentacao2(Double alimentacao2) {
		this.alimentacao2 = alimentacao2;
	}

	public void setAlimentacao3(Double alimentacao3) {
		this.alimentacao3 = alimentacao3;
	}

	public void setAlimentacao4(Double alimentacao4) {
		this.alimentacao4 = alimentacao4;
	}

	public void setAlimentacao5(Double alimentacao5) {
		this.alimentacao5 = alimentacao5;
	}

	public void setAlimentacao6(Double alimentacao6) {
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
	public double calcularCalorias() {
		double sum = 0;
		if(alimentacao1 == null) {
			alimentacao1 = 0.0;
		}
		else {
			sum += alimentacao1;
		}
		if(alimentacao2 == null) {
			alimentacao2 = 0.0;
		}
		else {
			sum += alimentacao2;
		}
		if(alimentacao3 == null) {
			alimentacao3 = 0.0;
		}
		else {
			sum += alimentacao3;
		}
		if(alimentacao4 == null) {
			alimentacao4 = 0.0;
		}
		else {
			sum += alimentacao4;
		}
		if(alimentacao5 == null) {
			alimentacao5 = 0.0;
		}
		else {
			sum += alimentacao5;
		}
		if(alimentacao6 == null) {
			alimentacao6 = 0.0;
		}
		else {
			sum += alimentacao6;
		}
		
		return sum;
	}
	
	
}
