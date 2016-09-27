package com.vidasaudavel.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@ManagedBean(name="mbQuestionario")
@SessionScoped
@Entity
@Table(name = "questionario")
public class Questionario implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_questionario;
	@Column(length=40,nullable=false)
	private String nm_usuario;	
	
	@Column
	private int idade;
	
	@Column(nullable=false)
	private double peso;
	
	@Column(nullable=false)
	private double altura;
	
	@Column(nullable=false)
	private double imc;
	
	@Column(length=30,nullable=false)
	private String regiao_usuario;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "questionario_alimento_rel",
	joinColumns = { @JoinColumn(name = "id_questionario") }, 
	inverseJoinColumns = { @JoinColumn(name = "id_alimento")})
	private List<Alimento> listaAlimento;

	
	public long getId_questionario() {
		return id_questionario;
	}

	public void setId_questionario(long id_questionario) {
		this.id_questionario = id_questionario;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getRegiao_usuario() {
		return regiao_usuario;
	}

	public void setRegiao_usuario(String regiao_usuario) {
		this.regiao_usuario = regiao_usuario;
	}

	public List<Alimento> getListaAlimento() {
		return listaAlimento;
	}

	public void setListaAlimento(List<Alimento> listaAlimento) {
		this.listaAlimento = listaAlimento;
	}
	
	
}
