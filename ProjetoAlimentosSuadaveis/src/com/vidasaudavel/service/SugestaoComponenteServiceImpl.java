package com.vidasaudavel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidasaudavel.dao.SugestaoComponenteDAO;
import com.vidasaudavel.model.SugestaoComponente;

@Service
@Transactional(readOnly = true)
public class SugestaoComponenteServiceImpl implements SugestaoComponenteService {

	private SugestaoComponenteDAO sugestaoComponenteDAO; 
	public void setSugestaoComponenteDAO(SugestaoComponenteDAO sugestaoComponenteDAO) {
		this.sugestaoComponenteDAO = sugestaoComponenteDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void addSugestaoComponente(SugestaoComponente c) {
		// TODO Auto-generated method stub
		sugestaoComponenteDAO.addSugestaoComponente(c);
		
	}

	@Override
	public List<SugestaoComponente> listSugestaoComponente() {
		// TODO Auto-generated method stub
		return sugestaoComponenteDAO.listSugestaoComponente();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateSugestaoComponente(SugestaoComponente c) {
		// TODO Auto-generated method stub
		sugestaoComponenteDAO.updateSugestaoComponente(c);
	}

	@Override
	@Transactional(readOnly = false)
	public void removeSugestaoComponenteById(int id) {
		// TODO Auto-generated method stub
		sugestaoComponenteDAO.removeSugestaoComponenteById(id);
	}

}
