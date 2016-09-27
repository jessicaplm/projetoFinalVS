package com.vidasaudavel.dao;

import java.util.List;

import com.vidasaudavel.model.Questionario;

public interface QuestionarioDAO {

	public void addQuestionario(Questionario c);

	public List<Questionario> listQuestionario();

	public void updateQuestionario(Questionario c);

	public void removeQuestionarioById(int id);
}
