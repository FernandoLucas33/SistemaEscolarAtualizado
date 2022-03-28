package br.com.infoschool.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.infoschool.model.Endereco;
import br.com.infoschool.repository.EnderecoRepository;
import br.com.infoschool.util.jpa.Transactional;

public class EnderecoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco salvar(Endereco endereco){
		return enderecoRepository.guardar(endereco);
	}
}
