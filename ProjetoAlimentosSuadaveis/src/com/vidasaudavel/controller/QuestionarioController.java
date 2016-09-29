package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.Questionario;
import com.vidasaudavel.model.TipoRegiao;

import com.vidasaudavel.service.QuestionarioService;

@ManagedBean(name = "questionarioController")
@Controller
@SessionScoped
public class QuestionarioController {

	private QuestionarioService questionarioService;
	private Questionario questionario;

	
	
	public QuestionarioController() {
	questionario = new Questionario();
	}

	
	public void addQuestionario(Questionario q){
		
		q.setImc( q.getPeso() / ( q.getAltura()*q.getAltura())); 
		questionario.setImc(q.getImc());
		
		//Logica que vai gerar as Informaccoes que a gente vai mostrar na tela !
		//mo caso as recomendacoes
		
		questionarioService.addQuestionario(q);	
		
	}
	
	
	
	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}


	public void setQuestionarioService(QuestionarioService questionarioService) {
		this.questionarioService = questionarioService;
	}

	public TipoRegiao[] getTipoRegiao() {
		return TipoRegiao.values();
	}
}
