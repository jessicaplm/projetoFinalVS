package com.vidasaudavel.service;





import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidasaudavel.dao.QuestionarioDAO;
import com.vidasaudavel.model.Questionario;
	
@Service
@Transactional(readOnly=true)
public class QuestionarioServiceImpl implements QuestionarioService {

	private QuestionarioDAO questionarioDAO;

	public void setQuestionarioDAO(QuestionarioDAO questionarioDAO) {
		this.questionarioDAO = questionarioDAO;
	}

	@Override
	@Transactional(readOnly=false)
	public void addQuestionario(Questionario c) {
		// TODO Auto-generated method stub
		questionarioDAO.addQuestionario(c);
	}

	@Override
	public List<Questionario> listQuestionario() {
		// TODO Auto-generated method stub
		return questionarioDAO.listQuestionario();
	}

	@Override
	@Transactional(readOnly=false)
	public void updateQuestionario(Questionario c) {
		// TODO Auto-generated method stub
		questionarioDAO.updateQuestionario(c);
	}

	@Override
	@Transactional(readOnly=false)
	public void removeQuestionarioById(int id) {
		// TODO Auto-generated method stub
		questionarioDAO.removeQuestionarioById(id);
	}
	
	
	
	
}
