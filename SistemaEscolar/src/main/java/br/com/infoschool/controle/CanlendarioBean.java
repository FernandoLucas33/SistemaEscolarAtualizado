package br.com.infoschool.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.infoschool.model.Calendario;
import br.com.infoschool.service.CalendarioService;
import br.com.infoschool.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CanlendarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CalendarioService calendarioService;
	
	private Calendario calendario; 
	private List<Calendario> eventos;
	
	@PostConstruct
	public void inicializar(){
		calendario = new Calendario();
	}
	
	public void salvar(){
		this.calendario = calendarioService.salvar(calendario);
		
		FacesUtil.addInfoMessage("Evento Salvo com Sucesso!");
	}

	
	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public List<Calendario> getEventos() {
		return eventos;
	}

	public void setEventos(List<Calendario> eventos) {
		this.eventos = eventos;
	}

	
}
