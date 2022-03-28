package br.com.infoschool.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.repository.AlunoRepository;
import br.com.infoschool.util.jpa.Transactional;

public class CadastroAlunoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepository alunoRepository;
	
	@Transactional
	public Aluno salvar(Aluno aluno){
		return alunoRepository.guardar(aluno);
	}

}
