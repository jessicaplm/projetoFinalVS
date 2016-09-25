package com.vidasaudavel.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import com.vidasaudavel.model.Alimento;
import com.vidasaudavel.service.AlimentoService;

@Controller
@ManagedBean(name = "alimentoController")
@SessionScoped
public class AlimentoController {

	private Alimento alimento;
	private AlimentoService alimentoService;
	private UploadedFile file;
    private List<Alimento> alimentos;
    private DefaultStreamedContent mostrarimagem; 

	public void setAlimentoService(AlimentoService alimentoService) {
		this.alimentoService = alimentoService;
	}

	public void addAlimento(Alimento a) {
		try {
			a.setImagem(file.getContents());

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.alimentoService.addAlimento(a);
	}

	public List<Alimento> listAlimento() {

		alimentos = this.alimentoService.listAlimento();
	
			mostrarimagem=  new DefaultStreamedContent(new ByteArrayInputStream(alimentos.get(1).getImagem()));
	
		
		return alimentos;

	}

	public void updateAlimento(Alimento a) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.alimentoService.updateAlimento(a);
	}

	public void removeAlimentoById(int id) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		this.alimentoService.removeAlimentoById(id);
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}
	
	
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			
			FacesMessage message = new FacesMessage("Succesful",
					file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}



	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public DefaultStreamedContent getMostrarimagem() {
		return mostrarimagem;
	}

	public void setMostrarimagem(DefaultStreamedContent mostrarimagem) {
		this.mostrarimagem = mostrarimagem;
	}

}
