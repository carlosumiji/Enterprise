package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.TipoBebida;
import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.dao.impl.BebidaDAOImpl;
import br.com.fiap.jpa.exception.CommitException;

public class DaoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		BebidaDAO dao = new BebidaDAOImpl(em);
		
		//Cadastrar
		Bebida bebida = new Bebida(TipoBebida.REFRIGERANTE, "Pepsi", new GregorianCalendar(2019, Calendar.JUNE, 2), null, false);
		
		
		try {
			dao.cadastrar(bebida);
			dao.commit();
			System.out.println("Criado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Bebida bebidaBusca = dao.buscar(bebida.getId());
		System.out.println(bebidaBusca.getBebida());
		
		//Atualizar
		bebidaBusca.setBebida("Coca-Cola");
		
		try {
			dao.atualizar(bebidaBusca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(bebidaBusca.getId());
			dao.commit();
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
		
	}

}
