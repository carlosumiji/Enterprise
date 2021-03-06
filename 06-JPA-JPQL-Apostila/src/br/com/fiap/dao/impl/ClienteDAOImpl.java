package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e",Cliente.class).setParameter("e", estado).getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :n",Cliente.class).setParameter("n", dias).getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :no " + "and c.endereco.cidade.nome like :cid",Cliente.class)
				.setParameter("no","%"+ nome +"%" )
				.setParameter("cid","%"+ cidade +"%") 
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(List<String> estados) {
		return em.createQuery("from Cliente c where " + "c.endereco.cidade.uf in :e", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	@Override
	public long contarQuantidade() {
		return em.createQuery("select count(c) from Cliente c", Long.class).getSingleResult();
	}

	
}







