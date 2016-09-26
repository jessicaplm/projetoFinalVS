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
	@Column
	private String nm_componente;
	@Column
	private String ds_componente;
	@Column
	private String benef_componente;
	@Column
	private String malef_componente;
	@Column
	private String url_imagem_componente;
	@Column
	private String link_componente;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
