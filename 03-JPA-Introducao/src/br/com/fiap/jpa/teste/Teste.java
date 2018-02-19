package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Transmissao;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Carro carro = new Carro("Celta", 2010, "1.0", "GM", "DDD-9875", 
				new GregorianCalendar(2010, Calendar.JANUARY, 2),
				false, false, null,Transmissao.MANUAL);
		
		em.getTransaction().begin(); //inicializa uma transação
		em.persist(carro);
		em.getTransaction().commit(); //realiza o commit
		
		em.close();
		fabrica.close();
	
	}
}
