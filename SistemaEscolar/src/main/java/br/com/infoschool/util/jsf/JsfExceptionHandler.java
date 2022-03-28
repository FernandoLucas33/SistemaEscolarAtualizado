package br.com.infoschool.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;

public class JsfExceptionHandler extends ExceptionHandlerWrapper {
	
	private ExceptionHandler wrapped;
	

	@Override
	public ExceptionHandler getWrapped() {
		return null;
	}

}
