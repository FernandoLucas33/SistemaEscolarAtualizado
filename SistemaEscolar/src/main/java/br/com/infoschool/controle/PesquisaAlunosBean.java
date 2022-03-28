package br.com.infoschool.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.repository.AlunoRepository;
import br.com.infoschool.repository.filter.AlunoFilter;

@Named
@ViewScoped
public class PesquisaAlunosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepository alunoRepository;
	
	
	private Aluno aluno;
	private AlunoFilter filtro;
	private List<Aluno> alunosFiltrados;
	private List<Aluno> listaAlunos;
	
	public PesquisaAlunosBean(){
		filtro = new AlunoFilter();
	}
	private void limpar(){
		filtro = new AlunoFilter();
	}
	public void listarAlunos(){
		listaAlunos = alunoRepository.filtrados(filtro);
	}
	
	public void pesquisar(){
		alunosFiltrados = alunoRepository.filtrados(filtro);
		limpar();
	}
	
	
	//metodo retorna foto
	  public String retornaFoto() {
	        if (this.aluno != null) {
	            if (this.aluno.getFoto() != null) {
	                return "/resources/imagens/" + this.aluno.getFoto();
	            } else {
	                return "/resources/imagens/foto.gif";
	            }
	        }
	        return "/resources/imagens/foto.gif";
	    }

	    public String retornaFoto(Aluno aluno) {
	        if (aluno != null) {
	            if (aluno.getFoto() != null) {
	                return "/resources/imagens/" + aluno.getFoto();
	            } else {
	                return "/resources/imagens/foto.gif";
	            }
	        }
	        return "/resources/imagens/foto.gif";
	    }
	    
	    
	    
	    
	    
	
	public List<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}


	public AlunoFilter getFiltro() {
		return filtro;
	}
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
