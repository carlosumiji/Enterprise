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
	}	
}
