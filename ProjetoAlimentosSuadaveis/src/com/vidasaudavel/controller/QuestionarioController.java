package com.vidasaudavel.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.model.PeriodoDia;
import com.vidasaudavel.model.Questionario;
import com.vidasaudavel.model.TipoRegiao;
import com.vidasaudavel.service.AlimentoService;
import com.vidasaudavel.service.QuestionarioService;

@ManagedBean(name = "questionarioController")
@Controller
@SessionScoped
public class QuestionarioController {

	private Questionario questionario;
	private Alimento alimento;
	private List<Alimento> alimentos;
	private List<Alimento> alimentosRespostaManha;
	private List<Alimento> alimentosRespostaTarde;
	private List<Alimento> alimentosRespostaNoite;
	private boolean disablePesquisa = false;
	private boolean selecionarsexmasc = true;
	private boolean selecionarsexfem = false;
	private String sexoSelecionado;
	private String respostaQuestionarioImc;

	public QuestionarioController() {
		questionario = new Questionario();
		alimento = new Alimento();
		alimentos = new ArrayList<Alimento>();
		alimentosRespostaManha = new ArrayList<Alimento>();
		alimentosRespostaTarde = new ArrayList<Alimento>();
		alimentosRespostaNoite = new ArrayList<Alimento>();
		sexoSelecionado = "Masculino";

	}

	private QuestionarioService questionarioService;

	public void setQuestionarioService(QuestionarioService questionarioService) {
		this.questionarioService = questionarioService;
	}

	private AlimentoService alimentoService;

	public void setAlimentoService(AlimentoService alimentoService) {
		this.alimentoService = alimentoService;
	}

	public void addQuestionario(Questionario q) {

		alimentosRespostaManha = new ArrayList<Alimento>();
		alimentosRespostaTarde = new ArrayList<Alimento>();
		alimentosRespostaNoite = new ArrayList<Alimento>();

		double imc = (q.getPeso() / (q.getAltura() * q.getAltura()));

		BigDecimal bd = new BigDecimal(imc).setScale(1, RoundingMode.HALF_EVEN);

		questionario.setImc(bd.doubleValue());

		recomendarListaAlimentos(q);

		q.setListaAlimento(new ArrayList<Alimento>());
		for (int i = 0; i < alimentosRespostaManha.size(); i++) {

			q.getListaAlimento().add(alimentosRespostaManha.get(i));
		}
		for (int i = 0; i < alimentosRespostaTarde.size(); i++) {
			q.getListaAlimento().add(alimentosRespostaTarde.get(i));
		}
		for (int i = 0; i < alimentosRespostaNoite.size(); i++) {
			q.getListaAlimento().add(alimentosRespostaNoite.get(i));
		}

		resultimc();

		questionarioService.addQuestionario(q);
		disablePesquisa = true;
		limparCampos();
	}

	public void resultimc() {
		if (questionario.getImc() < 18.5) {

			respostaQuestionarioImc = "Vocé esta abaixo do peso!";

		}
		// Peso normal

		if (questionario.getImc() > 18.5 && questionario.getImc() < 24.9) {

			respostaQuestionarioImc = "Seu Peso esta normal!";

		}
		// Sobrepeso
		if (questionario.getImc() > 24.9 && questionario.getImc() < 29.9) {

			respostaQuestionarioImc = "Vocé esta com sobrepeso, risco de obesidade!";
		}

		// Obesidade
		if (questionario.getImc() > 29.9) {

			respostaQuestionarioImc = "Vocé esta Obeso!";

		}
	}

	public void recomendarListaAlimentos(Questionario q) {
		// PARTE QUE VAI VIRAR UM METODO SÓ SETANDO O QUESTIONARIO COMO
		// PARAMETRO
		alimentos = alimentoService.listAlimento();

		for (int i = 0; i < alimentos.size(); i++) {

			if (questionario.getRegiao_usuario().equalsIgnoreCase(
					alimentos.get(i).getRegiao_tipica())) {
				// Abaixo do peso
				if (questionario.getImc() < 18.5
						&& alimentos.get(i).getCalorias() >= 300) {

					verificacaoDiaria(i);

				}
				// Peso normal

				if (questionario.getImc() > 18.5
						&& questionario.getImc() < 24.9
						&& alimentos.get(i).getCalorias() < 300
						&& alimentos.get(i).getCalorias() > 200) {

					verificacaoDiaria(i);

				}
				// Sobrepeso
				if (questionario.getImc() > 24.9
						&& questionario.getImc() < 29.9
						&& alimentos.get(i).getCalorias() < 200
						&& alimentos.get(i).getCalorias() > 100) {

					verificacaoDiaria(i);

				}

				// Obesidade
				if (questionario.getImc() > 29.9
						&& alimentos.get(i).getCalorias() <= 100) {

					verificacaoDiaria(i);

				}

			}
		}

		// PARTE QUE VAI VIRAR UM METODO SÓ SETANDO O QUESTIONARIO COMO
		// PARAMETRO FIM
	}

	public void verificacaoDiaria(int i) {
		if (alimentos.get(i).getPeriodo_dia()
				.equalsIgnoreCase(PeriodoDia.Manha.name())) {
			alimentosRespostaManha.add(alimentos.get(i));

		}
		if (alimentos.get(i).getPeriodo_dia()
				.equalsIgnoreCase(PeriodoDia.Tarde.name())) {
			alimentosRespostaTarde.add(alimentos.get(i));

		}
		if (alimentos.get(i).getPeriodo_dia()
				.equalsIgnoreCase(PeriodoDia.Noite.name())) {
			alimentosRespostaNoite.add(alimentos.get(i));

		}
	}

	public List<Alimento> listAlimento() {

		alimentos = this.alimentoService.listAlimento();
		return alimentos;

	}

	public void limparCampos() {
		questionario.setAltura(0);
		questionario.setIdade(0);
		questionario.setNm_usuario("");
		questionario.setPeso(0);
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public TipoRegiao[] getTipoRegiao() {
		return TipoRegiao.values();
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public List<Alimento> getAlimentosRespostaManha() {
		return alimentosRespostaManha;
	}

	public void setAlimentosRespostaManha(List<Alimento> alimentosRespostaManha) {
		this.alimentosRespostaManha = alimentosRespostaManha;
	}

	public List<Alimento> getAlimentosRespostaTarde() {
		return alimentosRespostaTarde;
	}

	public void setAlimentosRespostaTarde(List<Alimento> alimentosRespostaTarde) {
		this.alimentosRespostaTarde = alimentosRespostaTarde;
	}

	public List<Alimento> getAlimentosRespostaNoite() {
		return alimentosRespostaNoite;
	}

	public void setAlimentosRespostaNoite(List<Alimento> alimentosRespostaNoite) {
		this.alimentosRespostaNoite = alimentosRespostaNoite;
	}

	public boolean isDisablePesquisa() {
		return disablePesquisa;
	}

	public void setDisablePesquisa(boolean disablePesquisa) {
		this.disablePesquisa = disablePesquisa;
	}

	public boolean isSelecionarsexfem() {
		return selecionarsexfem;
	}

	public boolean isSelecionarsexmasc() {
		return selecionarsexmasc;
	}

	public void setSelecionarsexmasc(boolean selecionarsexmasc) {
		this.selecionarsexmasc = selecionarsexmasc;
	}

	public void setSelecionarsexfem(boolean selecionarsexfem) {
		this.selecionarsexfem = selecionarsexfem;
	}

	public String getSexoSelecionado() {
		return sexoSelecionado;
	}

	public void setSexoSelecionado(String sexoSelecionado) {
		this.sexoSelecionado = sexoSelecionado;
	}

	public String getRespostaQuestionarioImc() {
		return respostaQuestionarioImc;
	}

	public void setRespostaQuestionarioImc(String respostaQuestionarioImc) {
		this.respostaQuestionarioImc = respostaQuestionarioImc;
	}

	public void processValueChanges() {
		// TODO Auto-generated method stub
		if (sexoSelecionado.equalsIgnoreCase("Feminino")) {
			selecionarsexfem = true;
			selecionarsexmasc = false;
		} else if (sexoSelecionado.equalsIgnoreCase("Masculino")) {
			selecionarsexfem = false;
			selecionarsexmasc = true;
		}

	}

}
