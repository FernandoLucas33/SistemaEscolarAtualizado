package br.com.infoschool.controle;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.infoschool.model.Endereco;
import br.com.infoschool.service.EnderecoService;
import br.com.infoschool.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EnderecoService enderecoService;
	
	
	private Endereco endereco = new Endereco();
	
	private void limpar(){
		endereco = new Endereco();
	}

	public void salvarEndereco(){
		this.endereco = enderecoService.salvar(this.endereco);
		limpar();
		FacesUtil.addInfoMessage("Endereço salvo com sucesso!");
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
