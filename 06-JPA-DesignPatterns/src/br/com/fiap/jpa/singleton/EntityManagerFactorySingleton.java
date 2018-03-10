package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//1_Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//3-Atributo privado estatico
	private static EntityManagerFactory fabrica;
	
	//2-Metodo publico estatico
	public static EntityManagerFactory getInstance() {
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}
