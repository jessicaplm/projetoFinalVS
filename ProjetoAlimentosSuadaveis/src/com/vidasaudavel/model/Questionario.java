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
	@Column
	private String nm_usuario;
	@Column
	private int idade;
	@Column
	private double peso;
	@Column
	private double altura;
	@Column
	private double imc;
	@Column
	private String regiao_usuario;
	
	
}
