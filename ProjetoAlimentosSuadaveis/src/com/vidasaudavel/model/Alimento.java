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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@ManagedBean(name = "mbAlimento")
@SessionScoped
@Entity
@Table(name = "alimento")
public class Alimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_alimento;
	
	@Column(length=30,nullable=false)
	private String nm_alimento;
	
	@Column(length=20,nullable=false)
	private String regiao_tipica;
	
	@Column(length=8,nullable=false)
	private String periodo_dia;
	
	@Column(nullable=false)
	private int calorias;
	
	@Column(length=20)
	private String porcao;
	
	@Column(length=100)
	private String url_imagem_alimento;
	
	@Column(length=500)
	private String desc_alimento;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "alimento_componente_rel",
	joinColumns = { @JoinColumn(name = "id_alimento") }, 
	inverseJoinColumns = { @JoinColumn(name = "id_componente")})
	private List<Componente> listaComponentes;

	
	public long getId_alimento() {
		return id_alimento;
	}

	public void setId_alimento(long id_alimento) {
		this.id_alimento = id_alimento;
	}

	public String getNm_alimento() {
		return nm_alimento;
	}

	public void setNm_alimento(String nm_alimento) {
		this.nm_alimento = nm_alimento;
	}

	public String getRegiao_tipica() {
		return regiao_tipica;
	}

	public void setRegiao_tipica(String regiao_tipica) {
		this.regiao_tipica = regiao_tipica;
	}

	public String getPeriodo_dia() {
		return periodo_dia;
	}

	public void setPeriodo_dia(String periodo_dia) {
		this.periodo_dia = periodo_dia;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getPorcao() {
		return porcao;
	}

	public void setPorcao(String porcao) {
		this.porcao = porcao;
	}

	public String getUrl_imagem_alimento() {
		return url_imagem_alimento;
	}

	public void setUrl_imagem_alimento(String url_imagem_alimento) {
		this.url_imagem_alimento = url_imagem_alimento;
	}

	public String getDesc_alimento() {
		return desc_alimento;
	}

	public void setDesc_alimento(String desc_alimento) {
		this.desc_alimento = desc_alimento;
	}

	public List<Componente> getListaComponentes() {
		return listaComponentes;
	}

	public void setListaComponentes(List<Componente> listaComponentes) {
		this.listaComponentes = listaComponentes;
	}
	
	

}
