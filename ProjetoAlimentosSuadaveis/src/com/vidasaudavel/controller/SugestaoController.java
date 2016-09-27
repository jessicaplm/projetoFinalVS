package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.TipoSugestao;
import com.vidasaudavel.service.SugestaoService;

@ManagedBean(name="sugestaoController")
@Controller
@SessionScoped
public class SugestaoController {

	private SugestaoService sugestaoService;

	public void setSugestaoService(
			SugestaoService sugestaoService) {
		this.sugestaoService = sugestaoService;
	}
	
	public TipoSugestao[] getSexos() {
		return TipoSugestao.values();
	}
}
