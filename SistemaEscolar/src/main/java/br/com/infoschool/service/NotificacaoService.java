package br.com.infoschool.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.infoschool.model.Notificacao;
import br.com.infoschool.repository.NotificacaoRepository;
import br.com.infoschool.util.jpa.Transactional;

public class NotificacaoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NotificacaoRepository notificacaoRepository;
	
	@Transactional
	public Notificacao salvar(Notificacao notificacao){
		return notificacaoRepository.guardar(notificacao);
	}

}
