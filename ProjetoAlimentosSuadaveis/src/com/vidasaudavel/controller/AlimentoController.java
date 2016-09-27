package com.vidasaudavel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.PeriodoDia;
import com.vidasaudavel.model.TipoRegiao;
import com.vidasaudavel.model.TipoSugestao;
import com.vidasaudavel.service.AlimentoService;
import com.vidasaudavel.service.ComponenteService;
import com.vidasaudavel.service.ComponenteServiceImpl;

@Controller
@ManagedBean(name = "alimentoController")
@SessionScoped
public class AlimentoController {

	private Alimento alimento;
	private Componente componente;
	private AlimentoService alimentoService;
	private List<Alimento> alimentos;
	private List<Componente> componentes;
	private boolean hidden;

	public void setAlimentoService(AlimentoService alimentoService) {
		this.alimentoService = alimentoService;
	}

	private ComponenteService componenteService;

	public AlimentoController() {
		alimento = new Alimento();
		componente = new Componente();
		alimentos = new ArrayList<Alimento>();
		componentes = new ArrayList<Componente>();
		alimento.setPorcao("100");
	}

	public void addAlimento(Alimento a) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		if(componentes.size()>0){
		a.setListaComponentes(componentes);
		}

		this.alimentoService.addAlimento(a);

	}

	public void addListComponentes(Componente a) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		boolean existe = false;

		for (int i = 0; i < componentes.size(); i++) {

			if (a.getNm_componente().equalsIgnoreCase(
					componentes.get(i).getNm_componente())) {
				existe = true;
				FacesMessage message = new FacesMessage(
						"O item já foi adicionado ao alimento",
						a.getNm_componente() + " já foi adicionado!");
				FacesContext.getCurrentInstance().addMessage(null, message);

				break;
			}
		}
		if (existe == false) {

			Componente comp = new Componente();
			comp.setBenef_componente(a.getBenef_componente());
			comp.setDs_componente(a.getDs_componente());
			comp.setId_componente(a.getId_componente());
			comp.setLink_componente(a.getLink_componente());
			comp.setMalef_componente(a.getMalef_componente());
			comp.setNm_componente(a.getNm_componente());
			comp.setUrl_imagem_componente(a.getUrl_imagem_componente());

			FacesMessage message = new FacesMessage(
					"Item adicionado ao alimento", a.getNm_componente()
							+ " foi adicionado.");
			FacesContext.getCurrentInstance().addMessage(null, message);

			this.componentes.add(comp);
		}
	}

	public void removerListComponentes(Componente a) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		this.componentes.remove(a);

	}

	public List<Alimento> listAlimento() {

		alimentos = this.alimentoService.listAlimento();
		return alimentos;

	}
	public List<Alimento> getByNameAlimento(String n) {
		
		return this.alimentoService.getByNameAlimento(n);
	}

	public void updateAlimento(Alimento a) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.alimentoService.updateAlimento(a);
	}

	public void removeAlimentoById(int id) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.alimentoService.removeAlimentoById(id);
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	// FacesMessage message = new FacesMessage("Succesful",
	// file.getFileName() + " is uploaded.");
	// FacesContext.getCurrentInstance().addMessage(null, message);

	public TipoSugestao[] getTipoSugestoes() {
		return TipoSugestao.values();
	}

	public TipoRegiao[] getTipoRegioes() {
		return TipoRegiao.values();
	}

	public PeriodoDia[] getPeriodosDia() {
		return PeriodoDia.values();
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public void hideOrShow() {

		if (!hidden) {

			hidden = true;
		} else {

			hidden = false;
		}
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	

}
