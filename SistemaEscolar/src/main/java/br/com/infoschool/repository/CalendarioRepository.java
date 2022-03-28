package br.com.infoschool.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.infoschool.model.Calendario;

public class CalendarioRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Calendario guardar(Calendario calendario){
		return manager.merge(calendario);
		
	}

}
