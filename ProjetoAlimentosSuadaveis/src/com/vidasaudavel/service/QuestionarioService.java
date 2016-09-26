package com.vidasaudavel.service;

import java.util.List;

import com.vidasaudavel.model.Questionario;
import com.vidasaudavel.model.Sugestao;



public interface QuestionarioService {

	
	public void addQuestionario(Questionario c);

	public List<Questionario> listQuestionario();

	public void updateQuestionario(Questionario c);

	public void removeQuestionarioById(int id);
}
