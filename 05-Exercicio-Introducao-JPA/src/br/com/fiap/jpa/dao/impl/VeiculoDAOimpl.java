package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.VeiculoNaoEncontradoException;

public class VeiculoDAOimpl implements VeiculoDAO{

	private EntityManager em;

	public VeiculoDAOimpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Veiculo cadastar(Veiculo veiculo) {
		em.persist(veiculo);
		return veiculo;
	}

	@Override
	public Veiculo atualizar(Veiculo veiculo) {
		em.merge(veiculo);
		return veiculo;
	}

	@Override
	public void remover(int codigo) throws VeiculoNaoEncontradoException {
		Veiculo veiculo = buscar(codigo);
		if(veiculo == null) {
			throw new VeiculoNaoEncontradoException();
		}
		
	}

	@Override
	public Veiculo buscar(int codigo) {
		return em.find(Veiculo.class, codigo);
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
