package br.com.infoschool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String tituloEvento;
	/*private Date inicioEvento;
	private Date fimEvento;*/
	private String Descricaoevento;
	private Boolean statusEvento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTituloEvento() {
		return tituloEvento;
	}
	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}
	/*public Date getInicioEvento() {
		return inicioEvento;
	}
	public void setInicioEvento(Date inicioEvento) {
		this.inicioEvento = inicioEvento;
	}
	public Date getFimEvento() {
		return fimEvento;
	}
	public void setFimEvento(Date fimEvento) {
		this.fimEvento = fimEvento;
	}*/
	public String getDescricaoevento() {
		return Descricaoevento;
	}
	public void setDescricaoevento(String descricaoevento) {
		Descricaoevento = descricaoevento;
	}
	public Boolean getStatusEvento() {
		return statusEvento;
	}
	public void setStatusEvento(Boolean statusEvento) {
		this.statusEvento = statusEvento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendario other = (Calendario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
