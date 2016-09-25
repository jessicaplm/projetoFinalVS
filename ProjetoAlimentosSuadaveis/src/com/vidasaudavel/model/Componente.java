package com.vidasaudavel.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Componente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2201012060270019795L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idComponente;
	private String nomeComponente;
	private String descricaoComponente;
	
	
	
	

}
