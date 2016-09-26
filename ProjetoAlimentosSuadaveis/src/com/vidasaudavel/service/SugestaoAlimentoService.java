package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.SugestaoAlimento;

public interface SugestaoAlimentoService {

	public void addSugestaoAlimento(SugestaoAlimento c);

	public List<SugestaoAlimento> listSugestaoAlimento();

	public void updateSugestaoAlimento(SugestaoAlimento c);

	public void removeSugestaoAlimentoById(int id);
}
