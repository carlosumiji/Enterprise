package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MotoristasDAO;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.MotoristaNaoEncontradoException;

public class MotoristaDAOimpl implements MotoristasDAO {

	private EntityManager em;

	public MotoristaDAOimpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Motorista cadastrar(Motorista motorista) {
		em.persist(motorista);
		return motorista;
	}

	@Override
	public Motorista atualizar(Motorista motorista) {
		em.merge(motorista);
		return motorista;
	}

	@Override
	public void remover(int codigo) throws MotoristaNaoEncontradoException {
		Motorista motorista = buscar(codigo);
		if(motorista == null) {
			throw new MotoristaNaoEncontradoException();
		}

	}

	@Override
	public Motorista buscar(int codigo) {
		return em.find(Motorista.class, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				e.printStackTrace();
				throw new CommitException("Erro");
			}	
		}
	}

}
