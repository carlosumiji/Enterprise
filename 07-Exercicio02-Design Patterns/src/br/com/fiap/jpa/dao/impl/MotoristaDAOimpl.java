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
	}
}
