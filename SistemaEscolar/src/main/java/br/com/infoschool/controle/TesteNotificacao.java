package br.com.infoschool.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.infoschool.model.Aluno;
import br.com.infoschool.model.Notificacao;

public class TesteNotificacao {

	public static void main(String[] args) {

		
		
	
		
		
		
		Aluno aluno = new Aluno();
		aluno.setMatricula("1234567");
		aluno.setNome("Fernando Lucas");
		aluno.setSerie("8º");
		aluno.setTurma("A");
		aluno.setTurno("Noturno");
		
		List<Aluno> alunos = new ArrayList();
		alunos.add(aluno);
		
		Date local = new Date();
		Notificacao noti = new Notificacao();
		noti.setData(local);
		noti.setTipo("NEGATIVA-ADVERTÊNCIA");
		noti.setMensagem(" Aluno quebrou o patrimonio da escola");
		
		
	}

}
