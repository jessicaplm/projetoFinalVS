package com.vidasaudavel.dao;

import java.util.List;

import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.Sugestao;

public interface SugestaoDAO {

	public void addSugestao(Sugestao c);

	public List<Sugestao> listSugestao();

	public void updateSugestao(Sugestao c);

	public void removeSugestaoById(int id);
}
