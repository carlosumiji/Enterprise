package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorDatas(Calendar data1, Calendar data2);
	
	double calcularMediaPreco();
	
	//contar a quantidade de pacotes que possuem transporte
	long contarPorTransporte();
	
	//somar os preços  dos pacotes por periodo de data
	Double somarPorPeriodo(Calendar inicio, Calendar fim);
	
	//Somar os preços dos pacotes por periodo de data
	List<Pacote> buscarPorDescricao(String desc);
	
}
