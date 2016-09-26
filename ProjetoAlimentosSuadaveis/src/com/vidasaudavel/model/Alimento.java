package com.vidasaudavel.model;

import java.io.Serializable;
import java.util.List;






import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name="mbAlimento")
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
	@Column
	private String nm_alimento;
	@Column
	private String regiao_tipica;
	@Column
	private String periodo_dia;
	@Column
	private int calorias;
	@Column
	private String porcao;
	@Column
	private String url_imagem_alimento;
	@Column
	private String desc_alimento;
	
	
	
	
	
	
	
	
	
	
	
	

}
