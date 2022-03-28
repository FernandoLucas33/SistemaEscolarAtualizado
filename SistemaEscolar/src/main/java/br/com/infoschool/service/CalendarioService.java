package br.com.infoschool.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.infoschool.model.Calendario;
import br.com.infoschool.repository.CalendarioRepository;
import br.com.infoschool.util.jpa.Transactional;

public class CalendarioService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CalendarioRepository calendarioRepository;
	
	@Transactional
	public Calendario salvar(Calendario calendario){
		return calendarioRepository.guardar(calendario);
	}

}
