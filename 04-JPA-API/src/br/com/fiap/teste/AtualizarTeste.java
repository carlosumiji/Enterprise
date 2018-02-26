package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.TipoBebida;

public class AtualizarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
//		Bebida bebida = em.find(Bebida.class, 1);
//		
//		bebida.setBebida("Morango");
		
		Bebida bebida = new Bebida(TipoBebida.CERVEJA, "kaiser", new GregorianCalendar(2019, Calendar.JANUARY,2), null,true);
		
		bebida.setId(1);
		
		em.merge(bebida); 
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();

	}

}
