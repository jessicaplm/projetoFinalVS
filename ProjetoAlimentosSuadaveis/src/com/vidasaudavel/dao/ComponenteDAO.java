package com.vidasaudavel.dao;

import java.util.List;

import com.vidasaudavel.model.Componente;

public interface ComponenteDAO {

	public void addComponente(Componente c);

	public List<Componente> listComponente();

	public void updateComponente(Componente c);

	public void removeComponenteById(int id);

	public void getByNameComponente(String n);
}
