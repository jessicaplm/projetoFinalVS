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
	private long idAlimento;
	@Column
	private String nomeAlimento;
	@Column
	private String descricaoGeral;
	@Column
	private String descricaoEspecifica;
	@Column
	private String beneficios;
	@Column
	private String maleficios;
	@Column
	private int valorEnergetico;
	@Column
	private String vitaminas;
	@Column(columnDefinition= "LONGBLOB")
	private byte[] imagem;
	
	
	public long getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}
	public String getDescricaoGeral() {
		return descricaoGeral;
	}
	public void setDescricaoGeral(String descricaoGeral) {
		this.descricaoGeral = descricaoGeral;
	}
	public String getDescricaoEspecifica() {
		return descricaoEspecifica;
	}
	public void setDescricaoEspecifica(String descricaoEspecifica) {
		this.descricaoEspecifica = descricaoEspecifica;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public String getMaleficios() {
		return maleficios;
	}
	public void setMaleficios(String maleficios) {
		this.maleficios = maleficios;
	}
	public int getValorEnergetico() {
		return valorEnergetico;
	}
	public void setValorEnergetico(int valorEnergetico) {
		this.valorEnergetico = valorEnergetico;
	}
	public String getVitaminas() {
		return vitaminas;
	}
	public void setVitaminas(String vitaminas) {
		this.vitaminas = vitaminas;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}

	
//	private List<Componente> componente;
	
	
	

}
