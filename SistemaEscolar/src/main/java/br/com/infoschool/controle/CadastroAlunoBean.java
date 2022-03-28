package br.com.infoschool.controle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.model.Endereco;
import br.com.infoschool.service.CadastroAlunoService;
import br.com.infoschool.util.jsf.FacesUtil;

@Named
@javax.faces.view.ViewScoped
public class CadastroAlunoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAlunoService cadastroAlunoService;
	
	
	
	
	private Aluno aluno;
	private Endereco endereco;
	
	
	@PostConstruct
	public void inicializar(){
		aluno = new Aluno();
		endereco = new Endereco();
		
	}
	
	public void limpar(){
		aluno = new Aluno();
		endereco = new Endereco();
	}
	
	public void salvar(){
		this.aluno.setEndereco(endereco);
		this.endereco.setAluno(aluno);
		this.aluno = cadastroAlunoService.salvar(this.aluno);
		limpar();
		FacesUtil.addInfoMessage("Aluno Salvo com Sucesso!");
	}

	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		
		if (this.aluno != null){
			this.endereco = this.aluno.getEndereco();
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
