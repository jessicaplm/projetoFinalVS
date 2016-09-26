package com.vidasaudavel.model;

public enum PeriodoDia {

	Manha("Cafe da Manha"),
	Tarde("Almoco"),
	Noite("Jantar");
	
	
	private final String valor;
	PeriodoDia(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor(){
		return valor;
	}
	
}
