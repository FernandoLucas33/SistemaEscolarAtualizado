package br.com.infoschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.repository.AlunoRepository;
import br.com.infoschool.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	//@Inject
	private AlunoRepository alunoRepository;

	public AlunoConverter() {
		this.alunoRepository = CDIServiceLocator.getBean(AlunoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		Aluno retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = this.alunoRepository.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Aluno) value).getId().toString();
			
		}
		return "";
	}

}
