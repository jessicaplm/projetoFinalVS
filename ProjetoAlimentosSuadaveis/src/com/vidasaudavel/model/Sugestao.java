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


@ManagedBean(name="mbSugestaoAlimento")
@SessionScoped
@Entity
@Table(name="sugestaoAlimento")
public class Sugestao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAlimento;
	@Column
	private String nome;
	@Column
	private String tipo_sugestao;
	
	
	
}
