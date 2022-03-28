package br.com.infoschool.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.infoschool.model.Endereco;

public class EnderecoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Inject
	private EntityManager manager;
	
	public Endereco guardar(Endereco endereco){
		return manager.merge(endereco);
		
	}

}
