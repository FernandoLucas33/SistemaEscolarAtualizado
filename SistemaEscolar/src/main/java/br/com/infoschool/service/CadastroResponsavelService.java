package br.com.infoschool.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.infoschool.model.Responsavel;
import br.com.infoschool.repository.ResponsavelRepository;
import br.com.infoschool.util.jpa.Transactional;

public class CadastroResponsavelService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResponsavelRepository responsavelRepository;
	
	@Transactional
	public Responsavel salvar(Responsavel responsavel){
		return responsavelRepository.guardar(responsavel);
	}

}
