package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Bebida;

//Atualiza o obejeto co os dados do banco
public class RefreshTeste {

	public static void main(String[] args) {
		//Criar o EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
	
		//Buscar uma bebida
		Bebida bebida = em.find(Bebida.class, 1);
		
		//Exibir o nome
		System.out.println(bebida.getBebida());
		
		//Mudar o nome da bebida no java 
		bebida.setBebida("Haiken");
		
		//Exibir o nome 
		System.out.println(bebida.getBebida());
		
		//Fazer o refresh
		em.refresh(bebida);
		
		//Exibir o  nome
		System.out.println(bebida.getBebida());
		
		em.close();
		fabrica.close();
		
	}
	
}
