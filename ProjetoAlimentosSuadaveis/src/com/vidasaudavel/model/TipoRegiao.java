package com.vidasaudavel.model;

public enum TipoRegiao {

	Sul("Regiao Sul"),
	Nordeste("Regiao Nordeste"),
	Suldeste("Regiao Suldeste"),
	Norte("Regiao norte"),
	CentroOeste("Regiao Centro-Oeste");
	
	private final String valor;
	TipoRegiao(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor(){
		return valor;
	}
}
