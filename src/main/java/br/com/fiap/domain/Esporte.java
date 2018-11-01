package br.com.fiap.domain;

public enum Esporte {

	CORRIDA(1, "Corrida"),
	CICLISMO(2, "Ciclismo"),
	SKATE(3, "Skate");
	
	private Integer cod;
	private String descricao;
	
	private Esporte(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Esporte toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(Esporte e: Esporte.values()) {
			if(cod.equals(e.getCod())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
