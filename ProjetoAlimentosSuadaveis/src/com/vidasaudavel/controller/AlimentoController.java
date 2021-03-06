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
import com.vidasaudavel.model.Sugestao;
import com.vidasaudavel.model.TipoRegiao;
import com.vidasaudavel.model.TipoSugestao;
import com.vidasaudavel.service.AlimentoService;
import com.vidasaudavel.service.ComponenteService;
import com.vidasaudavel.service.ComponenteServiceImpl;
import com.vidasaudavel.service.SugestaoService;

@Controller
@ManagedBean(name = "alimentoController")
@SessionScoped
public class AlimentoController {

	private Alimento alimento;
	private Componente componente;
	private List<Componente> listComponentesAlimento;
	private List<Alimento> alimentos;
	private List<Componente> componentes;
	private List<Alimento> pesquisaAlimentos;
	private String valorPesquisa;
	private String valorPesquisasearch;
	private Alimento alimentoSelecionado;
	private boolean showSugestao = false;
	private Sugestao sugestao;

	private AlimentoService alimentoService;

	public void setAlimentoService(AlimentoService alimentoService) {
		this.alimentoService = alimentoService;
	}

	private SugestaoService sugestaoService;

	public void setSugestaoService(SugestaoService sugestaoService) {
		this.sugestaoService = sugestaoService;
	}

	public void addSugestaoAlimento(String nmSugestao) {
		try {
			sugestao = new Sugestao();

			sugestao.setTipo_sugestao(TipoSugestao.Alimento.getValor());
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

	//

	public boolean isShowSugestao() {
		return showSugestao;
	}

	public void setShowSugestao(boolean showSugestao) {
		this.showSugestao = showSugestao;
	}

	private ComponenteService componenteService;

	public AlimentoController() {
		// depois apagar se nao der certo
		sugestao = new Sugestao();
		//

		alimento = new Alimento();
		alimentoSelecionado = new Alimento();
		componente = new Componente();
		alimentos = new ArrayList<Alimento>();
		componentes = new ArrayList<Componente>();
		pesquisaAlimentos = new ArrayList<Alimento>();
		listComponentesAlimento = new ArrayList<Componente>();
		alimento.setPorcao("100");

	}

	public void addAlimento(Alimento a) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		if (componentes.size() > 0) {
			a.setListaComponentes(componentes);
		}

		this.alimentoService.addAlimento(a);
	
		FacesMessage message = new FacesMessage("Alimento Adicionado!",
				a.getNm_alimento() + " foi adicionado!");
		FacesContext.getCurrentInstance().addMessage(null, message);

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

	public List<Alimento> listByNameAlimento(String n) {
		if (!n.equals("")) {
			pesquisaAlimentos = this.alimentoService.listByNameAlimento(n);
			valorPesquisasearch = "";
			if (pesquisaAlimentos.size() <= 0) {
				showSugestao = true;

			}else{
				showSugestao = false;
			}
		}
		return pesquisaAlimentos;
	}

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();
		pesquisaAlimentos = this.alimentoService.listByNameAlimento(query);
		for (int i = 0; i < pesquisaAlimentos.size(); i++) {

			if (pesquisaAlimentos.get(i).getNm_alimento().toLowerCase()
					.startsWith(query)) {
				results.add(pesquisaAlimentos.get(i).getNm_alimento());
			}
		}
		pesquisaAlimentos = new ArrayList<Alimento>();
		return results;
	}

	public void fecharDialogo() {
		org.primefaces.context.RequestContext.getCurrentInstance().execute(
				"PF('dlg3').hide();");

	}

	public String mostrardadosAlimento() {

		return "/destalhesAlimento.xhtml";
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

	public String getValorPesquisasearch() {
		return valorPesquisasearch;
	}

	public void setValorPesquisasearch(String valorPesquisasearch) {
		this.valorPesquisasearch = valorPesquisasearch;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public List<Componente> getListComponentesAlimento() {
		return listComponentesAlimento;
	}

	public void setListComponentesAlimento(
			List<Componente> listComponentesAlimento) {
		this.listComponentesAlimento = listComponentesAlimento;
	}

	public List<Alimento> getPesquisaAlimentos() {
		return pesquisaAlimentos;
	}

	public void setPesquisaAlimentos(List<Alimento> pesquisaAlimentos) {
		this.pesquisaAlimentos = pesquisaAlimentos;
	}

	public String getValorPesquisa() {
		return valorPesquisa;
	}

	public Alimento getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(Alimento alimentoSelecionado) {
		this.alimentoSelecionado = alimentoSelecionado;
	}

	public void setValorPesquisa(String valorPesquisa) {
		this.valorPesquisa = valorPesquisa;
	}

}
