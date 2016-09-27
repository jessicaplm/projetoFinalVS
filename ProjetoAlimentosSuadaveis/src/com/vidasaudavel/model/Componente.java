package com.vidasaudavel.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="mbComponente")
@SessionScoped
@Entity
@Table(name="componente")
public class Componente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_componente;
	
	@Column(length=50,nullable=false)
	private String nm_componente;
	
	@Column(length=500,nullable=false)
	private String ds_componente;
	
	@Column(length=400)
	private String benef_componente;
	
	@Column(length=400)
	private String malef_componente;
	
	@Column(length=100,nullable=false)
	private String url_imagem_componente;
	
	@Column(length=100,nullable=false)
	private String link_componente;
	
	
	public long getId_componente() {
		return id_componente;
	}
	public void setId_componente(long id_componente) {
		this.id_componente = id_componente;
	}
	public String getNm_componente() {
		return nm_componente;
	}
	public void setNm_componente(String nm_componente) {
		this.nm_componente = nm_componente;
	}
	public String getDs_componente() {
		return ds_componente;
	}
	public void setDs_componente(String ds_componente) {
		this.ds_componente = ds_componente;
	}
	public String getBenef_componente() {
		return benef_componente;
	}
	public void setBenef_componente(String benef_componente) {
		this.benef_componente = benef_componente;
	}
	public String getMalef_componente() {
		return malef_componente;
	}
	public void setMalef_componente(String malef_componente) {
		this.malef_componente = malef_componente;
	}
	public String getUrl_imagem_componente() {
		return url_imagem_componente;
	}
	public void setUrl_imagem_componente(String url_imagem_componente) {
		this.url_imagem_componente = url_imagem_componente;
	}
	public String getLink_componente() {
		return link_componente;
	}
	public void setLink_componente(String link_componente) {
		this.link_componente = link_componente;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
