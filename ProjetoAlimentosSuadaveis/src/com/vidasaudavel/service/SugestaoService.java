package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.Sugestao;

public interface SugestaoService {

	public void addSugestao(Sugestao c);

	public List<Sugestao> listSugestao();

	public void updateSugestao(Sugestao c);

	public void removeSugestaoById(int id);
}
