package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Pacote;

public class ConsoleView2 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		System.out.println("Cliente: " + clienteDao.contarQuantidade());
		
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		System.out.println("Média preçao pacotes: " + pacoteDao.calcularMediaPreco());
		
		ReservaDAO reservaoDao = new ReservaDAOImpl(em);
		System.out.println("Qtd reserva do cliente: " + reservaoDao.quantidadeReserva(2));
		
		Calendar inicio = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2017, Calendar.DECEMBER, 31);
		
		System.out.println("Total de reservas: " + reservaoDao.contarQuantidadePorData(inicio, fim));
		
		em.close();
		fabrica.close();
	}
}
