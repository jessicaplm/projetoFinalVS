package com.vidasaudavel.dao;

import java.util.List;

import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.SugestaoAlimento;

public interface SugestaoAlimentoDAO {

	public void addSugestaoAlimento(SugestaoAlimento c);

	public List<SugestaoAlimento> listSugestaoAlimento();

	public void updateSugestaoAlimento(SugestaoAlimento c);

	public void removeSugestaoAlimentoById(int id);
}
