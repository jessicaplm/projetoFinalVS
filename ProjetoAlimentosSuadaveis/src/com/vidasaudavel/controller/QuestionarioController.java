package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.TipoRegiao;

import com.vidasaudavel.service.QuestionarioService;

@ManagedBean(name = "questionarioController")
@Controller
@SessionScoped
public class QuestionarioController {

	private QuestionarioService questionarioService;

	public void setQuestionarioService(QuestionarioService questionarioService) {
		this.questionarioService = questionarioService;
	}

	public TipoRegiao[] getTipoRegiao() {
		return TipoRegiao.values();
	}
}
