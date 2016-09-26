package com.vidasaudavel.dao;

import java.util.List;


import com.vidasaudavel.model.SugestaoComponente;

public interface SugestaoComponenteDAO {

	public void addSugestaoComponente(SugestaoComponente c);

	public List<SugestaoComponente> listSugestaoComponente();

	public void updateSugestaoComponente(SugestaoComponente c);

	public void removeSugestaoComponenteById(int id);
}
