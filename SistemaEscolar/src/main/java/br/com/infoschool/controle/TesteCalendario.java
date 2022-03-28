package br.com.infoschool.controle;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.infoschool.model.Calendario;

public class TesteCalendario implements Serializable{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistemaEscolar");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
			Calendario calendario = new Calendario();
			calendario.setTituloEvento("Evento Teste");
			calendario.setDescricaoevento("Evento Teste de persistencia");
			
			calendario.setStatusEvento(true);
			
		 manager.persist(calendario);
		trx.commit();
		
	
}
}
