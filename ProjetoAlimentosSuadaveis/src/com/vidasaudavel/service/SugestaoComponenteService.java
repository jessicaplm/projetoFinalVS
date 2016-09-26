package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.SugestaoComponente;

public interface SugestaoComponenteService  {
	
	public void addSugestaoComponente(SugestaoComponente c);

	public List<SugestaoComponente> listSugestaoComponente();

	public void updateSugestaoComponente(SugestaoComponente c);

	public void removeSugestaoComponenteById(int id);
}
