package br.com.infoschool.controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
     
    private UploadedFile file;
    
    
    public String uploader(){
    	
    	String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("imagens");
    	path=path.substring(0, path.indexOf("\\build"));
    	path=path+"\\web\\resources\\imagens";
    	
    	try{
    		InputStream in=file.getInputstream();
    		byte[] data = new byte[in.available()];
    		in.read(data);
    		FileOutputStream out = 
    				new FileOutputStream(new File(path+"demo.jpg"));
    		out.write(data);
    		in.close();
    		out.close();
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	  FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);;
        return null;
    }
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
      
            FacesMessage message = new FacesMessage("Imagem ", file.getFileName() + " carregada com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
	
}
