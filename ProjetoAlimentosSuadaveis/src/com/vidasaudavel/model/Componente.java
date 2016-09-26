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
	private long idComponente;
	@Column
	private String nomeComponente;
	@Column
	private String descricaoComponente;
	
	
	public long getIdComponente() {
		return idComponente;
	}
	public void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	public String getNomeComponente() {
		return nomeComponente;
	}
	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
	public String getDescricaoComponente() {
		return descricaoComponente;
	}
	public void setDescricaoComponente(String descricaoComponente) {
		this.descricaoComponente = descricaoComponente;
	}
	
	
	
	

}
