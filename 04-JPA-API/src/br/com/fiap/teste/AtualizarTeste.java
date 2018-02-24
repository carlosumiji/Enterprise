package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Bebida;

public class AtualizarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Bebida bebida = em.find(Bebida.class, 1);
		
		bebida.setBebida("Morango");
		
		em.getTransaction().begin();
		em.getTransaction().begin();
		
		em.close();
		fabrica.close();

	}

}
