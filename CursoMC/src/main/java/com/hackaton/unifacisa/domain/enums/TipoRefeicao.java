package com.hackaton.unifacisa.domain.enums;

public enum TipoRefeicao {
	
	DESJEJUN(1, "Desjejum"),
	LANCHEMANHA(2, "Lanche manhã"),
	LANCHETARDE(2, "Lanche Tarde"),
	ALMOCO(3, "Almiço"),
	JANTAR(4, "Jantar");

	private int cod;
	private String descricao;

	private TipoRefeicao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoRefeicao toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoRefeicao x : TipoRefeicao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id invãlido: " + cod);
	}

}
