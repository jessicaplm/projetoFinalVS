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
@Table(name="sugestao")
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
	
	public long getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo_sugestao() {
		return tipo_sugestao;
	}
	public void setTipo_sugestao(String tipo_sugestao) {
		this.tipo_sugestao = tipo_sugestao;
	}
	
	
	
}
