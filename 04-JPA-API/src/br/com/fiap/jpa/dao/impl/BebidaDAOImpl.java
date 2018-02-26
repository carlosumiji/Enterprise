package br.com.fiap.jpa.dao.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.TipoBebida;
import br.com.fiap.jpa.dao.BebidaDAO;

public class BebidaDAOImpl implements BebidaDAO{

	private EntityManager em;
	
	public BebidaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Bebida cadastrar(Bebida bebida) {
		em.persist(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		return bebida;
	}

	@Override
	public Bebida atualizar(Bebida bebida) {
		em.merge(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		return bebida;
	}

	@Override
	public void remover(int codigo) {
		Bebida bebida = buscar(codigo);
		em.remove(codigo);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public Bebida buscar(int codigo) {
		return em.find(Bebida.class, codigo);
		
	}
}
