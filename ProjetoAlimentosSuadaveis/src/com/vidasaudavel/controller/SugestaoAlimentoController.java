package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.service.SugestaoAlimentoService;

@ManagedBean(name="sugestaoAlimentoController")
@Controller
@SessionScoped
public class SugestaoAlimentoController {

	private SugestaoAlimentoService sugestaoAlimentoService;

	public void setSugestaoAlimentoService(
			SugestaoAlimentoService sugestaoAlimentoService) {
		this.sugestaoAlimentoService = sugestaoAlimentoService;
	}
}
