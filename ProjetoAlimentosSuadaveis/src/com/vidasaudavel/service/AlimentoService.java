package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.Alimento;

public interface AlimentoService {
	

	public void addAlimento(Alimento a );
	public List<Alimento> listAlimento();
	public void updateAlimento(Alimento a);
	public void removeAlimentoById(int id );

}
