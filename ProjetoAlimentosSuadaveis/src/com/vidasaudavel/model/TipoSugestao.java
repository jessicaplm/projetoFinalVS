package com.vidasaudavel.model;

public enum TipoSugestao {

	Comp("Componente"),
	Alim("Alimento");
	
	private final String valor;
	TipoSugestao(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor(){
		return valor;
	}
	
}
