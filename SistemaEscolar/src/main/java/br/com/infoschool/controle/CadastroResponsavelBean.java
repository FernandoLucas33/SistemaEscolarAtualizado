package br.com.infoschool.controle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.model.Responsavel;
import br.com.infoschool.service.CadastroResponsavelService;
import br.com.infoschool.util.jsf.FacesUtil;

@Named("cadastroResponsavel")
@ViewScoped
public class CadastroResponsavelBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroResponsavelService cadastroResponsavelService;

	private Responsavel responsavel;
	private Aluno alunoSelecionado;

	@PostConstruct
	public void inicializar() {
		responsavel = new Responsavel();
	}

	private void limpar() {
		responsavel = new Responsavel();
	}

	public void salvar() {
		this.responsavel = cadastroResponsavelService.salvar(this.responsavel);
		FacesUtil.addInfoMessage("Responsavel Salvo com Sucesso!");
		limpar();
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;

	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	
	
	
}
