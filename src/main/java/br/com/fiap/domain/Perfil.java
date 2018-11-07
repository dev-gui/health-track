package br.com.fiap.domain;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER");
	
	private Integer cod;
	private String descricao;
	
	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(Perfil e: Perfil.values()) {
			if(cod.equals(e.getCod())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
