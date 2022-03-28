package br.com.infoschool.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.infoschool.model.Responsavel;

public class ResponsavelRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	
	public Responsavel guardar(Responsavel responsavel){
		return manager.merge(responsavel);
	}

}
