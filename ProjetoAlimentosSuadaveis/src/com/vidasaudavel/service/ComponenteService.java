package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.model.Componente;

public interface ComponenteService {
	
	public void addComponente(Componente c);
	public List<Componente> listComponente();
	public void updateComponente(Componente c);
	public void removeComponenteById(int id );
	public List<Componente> listByNameComponente(String n);

}
