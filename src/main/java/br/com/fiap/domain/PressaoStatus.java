package br.com.fiap.domain;

public enum PressaoStatus {

	VERDE(1, "Verde"),
	AMARELO(2, "Amarelo"),
	VERMELHO(3, "Vermelho");
	
	private int cod;
	private String descricao;
	
	private PressaoStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static PressaoStatus toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(PressaoStatus e: PressaoStatus.values()) {
			if(cod.equals(e.getCod())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
