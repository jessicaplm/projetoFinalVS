package com.vidasaudavel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.service.SugestaoComponenteService;

@ManagedBean(name="sugestaoComponenteController")
@Controller
@SessionScoped
public class SugestaoComponenteController {

	private SugestaoComponenteService  sugestaoComponenteService;

	public void setSugestaoComponenteService(
			SugestaoComponenteService sugestaoComponenteService) {
		this.sugestaoComponenteService = sugestaoComponenteService;
	}
}
