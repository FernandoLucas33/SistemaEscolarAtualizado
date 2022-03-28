	package br.com.infoschool.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.infoschool.model.Notificacao;

public class NotificacaoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Notificacao guardar(Notificacao notificacao){
		return manager.merge(notificacao);
		
	}
}