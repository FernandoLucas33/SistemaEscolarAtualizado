	package br.com.infoschool.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import br.com.infoschool.model.Aluno;
import br.com.infoschool.repository.filter.AlunoFilter;

public class AlunoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	

	public Aluno guardar(Aluno aluno) {
		return manager.merge(aluno);
		
	}
	public Aluno porMatricula(String matricula){
		try{
			return manager.createQuery("from Aluno where upper(matricula) = :matricula", Aluno.class)
					.setParameter("Matricula", matricula.toUpperCase()).getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> filtrados(AlunoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluno.class);
		
		if(StringUtils.isNotBlank(filtro.getMatricula())){
		criteria.add(Restrictions.eq("matricula", filtro.getMatricula()));
		}
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getSerie())){
			criteria.add(Restrictions.like("serie", filtro.getSerie(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getTurma())){
			criteria.add(Restrictions.like("turma", filtro.getTurma(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getTurno())){
			criteria.add(Restrictions.like("turno", filtro.getTurno(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	public Aluno porId(Long id) {
		return manager.find(Aluno.class, id);
	}
	
}
