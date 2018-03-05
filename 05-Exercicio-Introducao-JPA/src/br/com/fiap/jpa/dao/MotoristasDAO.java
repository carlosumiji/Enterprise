package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.MotoristaNaoEncontradoException;

public interface MotoristasDAO {


	Motorista cadastrar(Motorista motorista);
	Motorista atualizar(Motorista motorista);
	void remover(int codigo) throws MotoristaNaoEncontradoException;
	Motorista buscar(int codigo);
	
	void commit() throws CommitException;
}
