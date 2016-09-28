package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.Sugestao;
import com.vidasaudavel.model.TipoSugestao;
import com.vidasaudavel.service.AlimentoService;
import com.vidasaudavel.service.SugestaoService;

@ManagedBean(name = "sugestaoController")
@Controller
@SessionScoped
public class SugestaoController {

	private SugestaoService sugestaoService;

	public void setSugestaoService(SugestaoService sugestaoService) {
		this.sugestaoService = sugestaoService;
	}

	private Sugestao sugestao;
	private boolean showSugestao = false;

	public boolean isShowSugestao() {
		return showSugestao;
	}

	public void setShowSugestao(boolean showSugestao) {
		this.showSugestao = showSugestao;
	}

	public SugestaoController() {

	}

	public void addSugestaoAlimento(String nmSugestao) {
		try {
			sugestao = new Sugestao();

			sugestao.setTipo_sugestao(TipoSugestao.Alimento.getValor());
			sugestao.setNome(nmSugestao);
			this.sugestaoService.addSugestao(sugestao);
			showSugestao = false;
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addSugestaoComponente(String nmSugestao) {
		try {
			sugestao = new Sugestao();
			sugestao.setTipo_sugestao(TipoSugestao.Componente.getValor());
			sugestao.setNome(nmSugestao);
			showSugestao = false;
			this.sugestaoService.addSugestao(sugestao);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Sugestao getSugestao() {
		return sugestao;
	}

	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}

	public TipoSugestao[] getTipoSugestao() {
		return TipoSugestao.values();
	}
}
