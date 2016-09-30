package com.vidasaudavel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import antlr.CppCodeGenerator;

import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.Sugestao;
import com.vidasaudavel.model.TipoSugestao;
import com.vidasaudavel.service.AlimentoService;
import com.vidasaudavel.service.ComponenteService;
import com.vidasaudavel.service.SugestaoService;

@Controller
@ManagedBean(name = "componenteController")
@SessionScoped
public class ComponenteController {

	private Componente componente;

	private List<Componente> componentes;
	private List<Componente> componenteslista;
	private List<Componente> pesquisaComponentes;
	private Componente componenteSelecionado;
	private boolean showSugestao = false;

	private ComponenteService componenteService;

	public void setComponenteService(ComponenteService componenteService) {
		this.componenteService = componenteService;
	}

	private Sugestao sugestao;
	private SugestaoService sugestaoService;

	public void setSugestaoService(SugestaoService sugestaoService) {
		this.sugestaoService = sugestaoService;
	}

	public void addSugestaoComponente(String nmSugestao) {
		try {
			sugestao = new Sugestao();

			sugestao.setTipo_sugestao(TipoSugestao.Componente.getValor());
			sugestao.setNome(nmSugestao);
			this.sugestaoService.addSugestao(sugestao);
			showSugestao = false;

			FacesMessage message = new FacesMessage(
					"O item já foi adicionado as Sugestoes", nmSugestao
							+ "  foi adicionado as Sugestoes!");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean isShowSugestao() {
		return showSugestao;
	}

	public ComponenteController() {
		componentes = new ArrayList<Componente>();
		componenteslista = new ArrayList<Componente>();
		componente = new Componente();
		componenteSelecionado = new Componente();
		pesquisaComponentes = new ArrayList<Componente>();
	}

	public void addComponentes(Componente c) {
		Componente comp = new Componente();
		componenteslista = listComponente();

		// componente = new Componente();
		boolean existe = false;

		for (int i = 0; i < componentes.size(); i++) {
			comp = componentes.get(i);
			if (c.getNm_componente().equalsIgnoreCase(comp.getNm_componente())) {

				FacesMessage msgs = new FacesMessage("Componente ja Inserido",
						"");
				FacesContext.getCurrentInstance().addMessage(null, msgs);

				existe = true;
				break;
			}
			// \
		}

		if (existe == false) {

			for (int i = 1; i < componenteslista.size(); i++) {
				comp = componenteslista.get(i);
				if (c.getNm_componente().equalsIgnoreCase(
						comp.getNm_componente())) {

					existe = true;

					break;
				}
				// comp = null;
			}

			if (existe == false) {
				Componente cp = new Componente();
				cp.setNm_componente(c.getNm_componente());
				cp.setDs_componente(c.getDs_componente());
				cp.setBenef_componente(c.getBenef_componente());
				cp.setLink_componente(c.getLink_componente());
				cp.setUrl_imagem_componente(c.getUrl_imagem_componente());
				cp.setMalef_componente(c.getMalef_componente());

				FacesMessage msgs = new FacesMessage(
						"Componente adicionado a lista!", "");
				FacesContext.getCurrentInstance().addMessage(null, msgs);

				componentes.add(cp);
			}

		}
	}

	public void deletComponente(Componente c) {

		componentes.remove(c);
	}

	public void addComponente(Componente c) {
		try {
			for (int i = 0; i < componentes.size(); i++) {
				this.componenteService.addComponente(componentes.get(i));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	public List<Componente> listComponente() {

		return this.componenteService.listComponente();

	}

	public void updateComponente(Componente c) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.componenteService.updateComponente(c);
	}

	public void removeComponenteById(int id) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.componenteService.removeComponenteById(id);
	}

	public List<Componente> listComponentebyName(String n) {

		pesquisaComponentes = this.componenteService.listByNameComponente(n);

		if (pesquisaComponentes.size() <= 0) {
			showSugestao = true;

		}

		return pesquisaComponentes;

	}

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();
		pesquisaComponentes = this.componenteService
				.listByNameComponente(query);
		for (int i = 0; i < pesquisaComponentes.size(); i++) {

			if (pesquisaComponentes.get(i).getNm_componente().toLowerCase()
					.startsWith(query)) {
				results.add(pesquisaComponentes.get(i).getNm_componente());
			}
		}
		pesquisaComponentes = new ArrayList<Componente>();
		return results;
	}

	public List<Componente> getPesquisaComponentes() {
		return pesquisaComponentes;
	}

	public void setPesquisaComponentes(List<Componente> pesquisaComponentes) {
		this.pesquisaComponentes = pesquisaComponentes;
	}

	public Componente getComponenteSelecionado() {
		return componenteSelecionado;
	}

	public void setComponenteSelecionado(Componente componenteSelecionado) {
		this.componenteSelecionado = componenteSelecionado;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public void setShowSugestao(boolean showSugestao) {
		this.showSugestao = showSugestao;
	}

}
