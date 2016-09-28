package com.vidasaudavel.model;

public enum TipoSugestao {

	Componente("Componente"),
	Alimento("Alimento");
	
	private final String valor;
	TipoSugestao(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor(){
		return valor;
	}
	
}
