package com.vidasaudavel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidasaudavel.dao.AlimentoDAO;
import com.vidasaudavel.dao.SugestaoAlimentoDAO;
import com.vidasaudavel.model.SugestaoAlimento;
@Service
@Transactional(readOnly = true)
public class SugestaoAlimentoServiceImpl implements SugestaoAlimentoService {

	private SugestaoAlimentoDAO sugestaoAlimentoDAO;


	public void setSugestaoAlimentoDAO(SugestaoAlimentoDAO sugestaoAlimentoDAO) {
		this.sugestaoAlimentoDAO = sugestaoAlimentoDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void addSugestaoAlimento(SugestaoAlimento c) {
		// TODO Auto-generated method stub
		sugestaoAlimentoDAO.addSugestaoAlimento(c);
	}

	@Override
	public List<SugestaoAlimento> listSugestaoAlimento() {
		// TODO Auto-generated method stub
		return sugestaoAlimentoDAO.listSugestaoAlimento();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateSugestaoAlimento(SugestaoAlimento c) {
		// TODO Auto-generated method stub
		sugestaoAlimentoDAO.updateSugestaoAlimento(c);
	}

	@Override
	@Transactional(readOnly = false)
	public void removeSugestaoAlimentoById(int id) {
		// TODO Auto-generated method stub
		sugestaoAlimentoDAO.removeSugestaoAlimentoById(id);
	}

}
