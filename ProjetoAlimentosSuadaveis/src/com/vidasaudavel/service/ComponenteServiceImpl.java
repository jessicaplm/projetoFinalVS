package com.vidasaudavel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidasaudavel.dao.AlimentoDAO;
import com.vidasaudavel.dao.ComponenteDAO;
import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.model.Componente;
@Service
@Transactional(readOnly=true)
public class ComponenteServiceImpl implements ComponenteService {

	private ComponenteDAO componenteDAO;
	
	public void setComponenteDAO(ComponenteDAO componenteDAO) {
		this.componenteDAO = componenteDAO;
	}

	@Override
	@Transactional(readOnly=false)
	public void addComponente(Componente c) {
		// TODO Auto-generated method stub
		componenteDAO.addComponente(c);
	}

	@Override
	public List<Componente> listComponente() {
		// TODO Auto-generated method stub
		return componenteDAO.listComponente();
	}

	@Override
	@Transactional(readOnly=false)
	public void updateComponente(Componente c) {
		// TODO Auto-generated method stub
		componenteDAO.updateComponente(c);
	}

	@Override
	@Transactional(readOnly=false)
	public void removeComponenteById(int id) {
		// TODO Auto-generated method stub
		componenteDAO.removeComponenteById(id);
	}
	



}
