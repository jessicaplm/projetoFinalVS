package com.vidasaudavel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vidasaudavel.dao.AlimentoDAO;
import com.vidasaudavel.model.Alimento;

@Service
@Transactional(readOnly = true)
public class AlimentoServiceImpl implements AlimentoService {

	private AlimentoDAO alimentoDAO;

	public void setAlimentoDAO(AlimentoDAO alimentoDAO) {
		this.alimentoDAO = alimentoDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void addAlimento(Alimento a) {
		// TODO Auto-generated method stub
		this.alimentoDAO.addAlimento(a);
	}

	@Override
	public List<Alimento> listAlimento() {
		// TODO Auto-generated method stub
		return this.alimentoDAO.listAlimento();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateAlimento(Alimento a) {
		// TODO Auto-generated method stub
		this.alimentoDAO.updateAlimento(a);
	}

	@Override
	@Transactional(readOnly = false)
	public void removeAlimentoById(int id) {
		// TODO Auto-generated method stub
		this.alimentoDAO.removeAlimentoById(id);
	}

}
