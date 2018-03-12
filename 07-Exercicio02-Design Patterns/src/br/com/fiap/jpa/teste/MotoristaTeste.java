package br.com.fiap.jpa.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;

public class MotoristaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar 
		Motorista motorista = new Motorista(1, "Fulano", new GregorianCalendar(2018, GregorianCalendar.AUGUST, 10), null, Genero.MASCULINO);
	}

}
