package com.vidasaudavel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vidasaudavel.dao.SugestaoDAO;
import com.vidasaudavel.model.Sugestao;
@Service
@Transactional(readOnly = true)
public class SugestaoServiceImpl implements SugestaoService {

	private SugestaoDAO sugestaoDAO;


	public void setSugestaoDAO(SugestaoDAO sugestaoDAO) {
		this.sugestaoDAO = sugestaoDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void addSugestao(Sugestao c) {
		// TODO Auto-generated method stub
		sugestaoDAO.addSugestao(c);
	}

	@Override
	public List<Sugestao> listSugestao() {
		// TODO Auto-generated method stub
		return sugestaoDAO.listSugestao();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateSugestao(Sugestao c) {
		// TODO Auto-generated method stub
		sugestaoDAO.updateSugestao(c);
	}

	@Override
	@Transactional(readOnly = false)
	public void removeSugestaoById(int id) {
		// TODO Auto-generated method stub
		sugestaoDAO.removeSugestaoById(id);
	}

}
