package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.TipoBebida;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		EntityManager em = fabrica.createEntityManager();
		
		Bebida bebida = new Bebida(TipoBebida.SUCO, "Laranja", Calendar.getInstance(), null, false);
		
		em.persist(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();		
		
		em.close();
		fabrica.close();
	}

}
