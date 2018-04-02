package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//listar as cidades
		CidadeDAO dao = new CidadeDAOImpl(em);
		List<Cidade> lista = dao.listar();
		System.out.println("Listar Cidades");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("Buscar por Nome");
		lista = dao.buscarPorNome("a");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		
		em.close();
		fabrica.close();
		
	}

}



