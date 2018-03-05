package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.VeiculoNaoEncontradoException;

public interface VeiculoDAO {

	Veiculo cadastar(Veiculo veiculo);
	Veiculo atualizar(Veiculo veiculo);
	void remover(int codigo) throws VeiculoNaoEncontradoException;
	Veiculo buscar(int codigo);
	
	void commit() throws CommitException;
	
}
