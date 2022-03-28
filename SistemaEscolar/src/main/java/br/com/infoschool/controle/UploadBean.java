package br.com.infoschool.controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.repository.AlunoRepository;
import br.com.infoschool.repository.filter.AlunoFilter;


@Named
@RequestScoped
public class UploadBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UploadedFile file;
	
	@Inject
	private AlunoRepository alunoRepository;
	
	private Aluno aluno;
	private AlunoFilter filtro;
	private List<Aluno> alunosFiltrados;
	private List<Aluno> listaAlunos;
	
	public UploadBean(){
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

	    
	    //processar foto
	    public void processarFoto(FileUploadEvent event) {

	        ServletContext servletContext = (ServletContext) FacesContext.
	                getCurrentInstance().getExternalContext().getContext();
	        String absoluteDiskPath = servletContext.getRealPath("/resources/imagens/");
	        File targetFolder = new File(absoluteDiskPath);
	        if (!targetFolder.exists()) {
	            targetFolder.mkdirs();

	        }

	        try (InputStream inputStream = event.getFile().getInputstream()) {
	            OutputStream out;
	            out = new FileOutputStream(new File(targetFolder, event.getFile().getFileName()));
	            int read;
	            byte[] bytes = new byte[1024];
	            while ((read = inputStream.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            }
	            out.flush();
	            out.close();
	            this.aluno.setFoto(event.getFile().getFileName());

	           // Util.criarAviso("Foto processada!");
	          //  Util.executarJavaScript("PF('dlgfoto').hide();");
	         //   Util.atualizarForm("criar:pic");
	        } catch (IOException ex) {
	           // Util.criarAvisoErro("ERRO:!" + ex);

	        }

	    }
	    
	    
	    
	
	
	//metodo upload
	public String upload() {		
		String name = file.getFileName();
		long size = file.getSize();
		
		String path = "/resources/imagens/";
		copyFileToDir(file, path);
		
		FacesMessage msg = new FacesMessage("O arquivo " + name + " foi enviado. Tamanho " + size + " bytes.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return null;
	}
	
	//metodo onUnpload
	public void onUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		String path = "/resources/imagens/";
		copyFileToDir(uploadedFile, path);
		
		String name = uploadedFile.getFileName();
		long size = uploadedFile.getSize();
		
		FacesMessage msg = new FacesMessage("O arquivo " + name + " foi enviado. Tamanho " + size + " bytes.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}



	private static void copyFileToDir(UploadedFile file, String dir) {
		if (file == null) {
			return;
		}
		
		OutputStream out = null;
		
		try {
			try {
				InputStream in = file.getInputstream();
				
				File outputFile = new File(dir, file.getFileName());
				
				out = new FileOutputStream(outputFile);
				
				byte[] buffer = new byte[1024];
				
				while (true) {
					int bytes = in.read(buffer);
					if (bytes < 0) {
						break;
					}
					
					out.write(buffer, 0, bytes);
				}
			} finally {
				if (out != null) {
					out.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public AlunoFilter getFiltro() {
		return filtro;
	}
	public void setFiltro(AlunoFilter filtro) {
		this.filtro = filtro;
	}
	public List<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}
	public void setAlunosFiltrados(List<Aluno> alunosFiltrados) {
		this.alunosFiltrados = alunosFiltrados;
	}
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	
	
}
